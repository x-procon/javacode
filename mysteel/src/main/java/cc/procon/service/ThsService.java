package cc.procon.service;

import Ths.JDIBridge;
import cc.procon.mapper.dw.DimIncrMapper;
import cc.procon.mapper.ods.ThsFuturesDataMapper;
import cc.procon.mapper.ods.ThsFuturesInfoMapper;
import cc.procon.model.po.ThsApiFuturesData;
import cc.procon.model.po.ThsApiFuturesInfo;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

/**
 * 同花顺service
 *
 * @author procon
 * @since 2022-11-23
 */
@Slf4j
@Service
public class ThsService {


    @Autowired
    private ThsFuturesDataMapper thsFuturesDataMapper;
    @Autowired
    private ThsFuturesInfoMapper thsFuturesInfoMapper;
    public static final String TABLE_NAME = "T_THS_API_FUTURES_DATA";
    @Autowired
    RetryTemplate retryTemplate;

    @Autowired
    private DimIncrMapper dimIncrMapper;



    public void compensationRangeIndexFromIndex(int start,int end) {
        List<ThsApiFuturesInfo> apiFuturesInfoList = thsFuturesInfoMapper.queryRangeFuturesFromIndex(start,end);
        log.info("需要处理指标的数量:{}",apiFuturesInfoList.size());
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        RangeForkJoinTask rangeForkJoinTask = new RangeForkJoinTask(0,apiFuturesInfoList.size(),apiFuturesInfoList);
        forkJoinPool.submit(rangeForkJoinTask);
    }

    public void thsCompensation(String indexCode) {
        ThsApiFuturesInfo thsApiFuturesInfo = thsFuturesInfoMapper.queryFutureInfoByIndexCode(indexCode);
        if (Objects.isNull(thsApiFuturesInfo)) {
            log.error("指标{}信息不存在", indexCode);
            return;
        }
        ThsApiFuturesData futuresData = thsFuturesDataMapper.queryFuturesMaxDate(indexCode);
        String beginTimeStr;
        if (Objects.nonNull(futuresData)) {
            beginTimeStr = DateUtil.format(futuresData.getIndexValueTime(),DatePattern.NORM_DATE_PATTERN);
        } else {
            beginTimeStr = "2000-05-01";
        }
        login();
        log.info("指标：{}，开始时间:{}",indexCode,beginTimeStr);
        String indexEnName = thsApiFuturesInfo.getIndexEnName();
        String contractCode = thsApiFuturesInfo.getContractCode();
        List<ThsApiFuturesData> futuresDataList;
        //区间行情
        futuresDataList = parseFuturesDataRangeMarket(indexCode, indexEnName, contractCode, beginTimeStr);
        //指标数据入库
        if (CollUtil.isNotEmpty(futuresDataList)) {
            retryTemplate.execute(context -> {
                long currentTimeMillis = System.currentTimeMillis();
                List<List<ThsApiFuturesData>> futuresPartition = Lists.partition(futuresDataList, 3000);
                int ret = 0;
                for (List<ThsApiFuturesData> thsApiFuturesData : futuresPartition) {
                    int i = thsFuturesDataMapper.mergeDataList(thsApiFuturesData);
                    ret = ret + i;
                }
                //通知对接码数据更新
                dimIncrMapper.insertOrUpdate(TABLE_NAME, currentTimeMillis, 1);
                log.info("同花顺期货，指标:{},更新:{}个", indexCode, ret);
                return true;
            });
        }

    }

    public void login() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.loadLibrary("iFinDJava_x64");
        } else {
            System.load("/apply/ths/bin64/libFTDataInterface.so");
        }
        JDIBridge.THS_iFinDLogin("hxsec018", "666888");
    }
    List<ThsApiFuturesData> parseFuturesDataRangeMarket(String indexCode, String indexEnName
            , String contractCode, String beginTime) {
        List<ThsApiFuturesData> futuresDataList = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String localDateStr = localDate.format(fmt);

        List<String> dates = findDates(beginTime, localDateStr);
        for (String date : dates) {
            String futuresDataStr = JDIBridge.THS_BasicData(contractCode, indexEnName, date);
            if (StrUtil.isNotEmpty(futuresDataStr)) {
                JSONObject object = JSON.parseObject(futuresDataStr);
                if ("0".equals(object.getString("errorcode"))) {
                    try {
                        // 遍历其中tables的结果数据
                        ThsApiFuturesData futuresData = new ThsApiFuturesData();
                        futuresData.setIndexCode(indexCode);
                        JSONArray tableArr = object.getJSONArray("tables");
                        JSONObject data = JSON.parseObject(tableArr.get(0).toString());
                        JSONArray valueArr = JSON.parseObject(data.get("table").toString()).getJSONArray(indexEnName);
                        futuresData.setIndexCode(indexCode);
                        if (!valueArr.isEmpty() && Objects.isNull(valueArr.get(0))) {
                            futuresData.setIndexValue("");
                        } else {
                            futuresData.setIndexValue(valueArr.get(0).toString());
                        }
                        futuresData.setIndexValueTime(new java.sql.Date(DateUtil.parse(date, "yyyy-MM-dd").getTime()));
                        futuresData.setIsDelete(0L);
                        futuresData.setIsQuality(1L);
                        futuresData.setHtUniqueCode("");
                        futuresData.setDataCreateTime(System.currentTimeMillis());
                        futuresData.setDataUpdateTime(System.currentTimeMillis());
                        futuresDataList.add(futuresData);

                    } catch (Exception e) {
                        log.error("同花顺期货数据解析错误，错误数据--》{}", object, e);
                    }

                }
            } else {
                log.error("同花顺期货指标编码：{} 查询失败:{}", indexCode, futuresDataStr);
            }
        }
        return futuresDataList;
    }

    public List<String> findDates(String dBegin, String dEnd) {
        //装返回的日期集合容器
        List<String> dateList = new ArrayList<>();
        //日期工具类准备
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //设置开始时间
            Calendar calBegin = Calendar.getInstance();
            calBegin.setTime(format.parse(dBegin));

            //设置结束时间
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(format.parse(dEnd));


            //将第一个月添加里面去
            dateList.add(format.format(calBegin.getTime()));
            // 每次循环给calBegin日期加一天，直到calBegin.getTime()时间等于dEnd
            while (format.parse(dEnd).after(calBegin.getTime())) {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                calBegin.add(Calendar.DAY_OF_MONTH, 1);
                dateList.add(format.format(calBegin.getTime()));
            }
        } catch (ParseException e) {
            log.error("日期转换失败");
        }
        return dateList;
    }
}
