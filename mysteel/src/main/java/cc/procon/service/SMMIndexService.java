package cc.procon.service;

import cc.procon.mapper.SMMIndexMapper;
import cc.procon.model.po.SMMIndexDataPO;
import cc.procon.util.MD5Util;
import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 上海有色service
 *
 * @author procon
 * @since 2022-10-12
 */
@Service
@Slf4j
public class SMMIndexService {

    private static final String USERNAME = "18116397859";
    private static final String PASSWORD = "htqh201920";
    private static final String DATA = "data";
    private static final String TOKEN = "token";
    private static final String SMM_DATA_TABLE_NAME = "SMM_API_INDEX_DATA";



    @Autowired
    private SMMClientService smmClient;

    @Autowired
    private SMMIndexMapper smmIndexMapper;



    public void getAllSmmIndexData() {
        String token = auth();
        List<String> quotaIds = smmIndexMapper.selectAllQuotaId();

        SMMIndexService.GetAllSmmIndexDataJoinTask calcForJoinTask = new SMMIndexService.GetAllSmmIndexDataJoinTask(quotaIds, 0, quotaIds.size() - 1, token);

        // 这是Fork/Join框架的线程池
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture = pool.submit(calcForJoinTask);
        try {
            taskFuture.get();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

     class GetAllSmmIndexDataJoinTask extends RecursiveTask<Integer>{


        private List<String> indexCodeList;
        private Integer startValue;
        private Integer endValue;
        private String token;
        //任务拆分最小单位,拆分到这个单位就不能拆分了,即阈值
        private int splitMinThreshold= 100;

        public GetAllSmmIndexDataJoinTask(List<String> indexCodeList, Integer startValue, Integer endValue, String token) {
            this.indexCodeList = indexCodeList;
            this.startValue = startValue;
            this.endValue = endValue;
            this.token = token;
        }
        @Override
        protected Integer compute() {
            if (endValue - startValue < splitMinThreshold) {
                log.info("---start:---{}---end:----{}--", startValue, endValue);
                int i = 0;
                for (String quotaId : indexCodeList.subList(startValue, endValue + 1)) {
                   int count = insertAndUpdateIndexData(quotaId, token);
                   i = i+ count;
                }
                log.info("---i:{}",i);
                return i;
            }else {

                SMMIndexService.GetAllSmmIndexDataJoinTask leftJoinTask = new SMMIndexService.GetAllSmmIndexDataJoinTask(indexCodeList, startValue, (startValue + endValue) / 2, token);
                leftJoinTask.fork();
                SMMIndexService.GetAllSmmIndexDataJoinTask rightJoinTask = new SMMIndexService.GetAllSmmIndexDataJoinTask(indexCodeList, (startValue + endValue) / 2 + 1, endValue, token);
                rightJoinTask.fork();
                return leftJoinTask.join()+rightJoinTask.join();
            }

        }

    }


    public int insertAndUpdateIndexData(String quotaId, String token) {


        //2.通过指标集合 查询数据集
        Map source = null;
        try {
            source = smmClient.quotaData(quotaId, null, null, token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Map data = (Map) source.get(DATA);

        List<Map> field = (List<Map>) data.get("field");
        List<List<String>> content = (List<List<String>>) data.get("content");

        List<SMMIndexDataPO> dataPOS = new ArrayList<>();
        Map fields = field.get(1);

        if (!CollectionUtils.isEmpty(content)) {
            for (List<String> item : content) {
                if (item.get(0) != null && item.get(1) != null) {
                    Map<Object, Object> newContent = new HashMap<>();
                    newContent.putAll(fields);
                    fields.put("data_date", item.get(0));
                    fields.put("data_value", item.get(1));
                    SMMIndexDataPO dataPO = JSON.parseObject(JSON.toJSONString(fields), SMMIndexDataPO.class);
                    dataPO.setDataCreateTime(System.currentTimeMillis());
                    dataPO.setDataUpdateTime(System.currentTimeMillis());
                    dataPO.setIsQuality(1L);
                    dataPO.setIsDelete(0L);
                    dataPOS.add(dataPO);
                }
            }
        }
        if(CollUtil.isNotEmpty(dataPOS)){
            log.info("更新指标:{},大小:{}",quotaId,dataPOS.size());
            return smmIndexMapper.mergeList(dataPOS);
        }
        //3.对比入库
       return 0;

    }



    public String auth() {
        String encodeByMd5;
        encodeByMd5 = MD5Util.md5Encode(PASSWORD);
        Map source = smmClient.auth(USERNAME, encodeByMd5, "source");
        Map data = (Map) source.get(DATA);
        if (data == null || !data.containsKey(TOKEN)) {
            throw new RuntimeException("获取token异常！");
        }
        return (String) data.get(TOKEN);
    }
}


