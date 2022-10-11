package cc.procon.service;

import cc.procon.mapper.ModifyColumnMapper;
import cc.procon.model.po.MbIndexPO;
import cc.procon.model.po.TriggerPO;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author procon
 * @since 2022-09-20
 */
@Service
public class ModifyColumnService {

    private static final Integer DEFAULT_PAGE_SIZE = 5000;

    @Autowired
    private ModifyColumnMapper modifyColumnMapper;

    public void modifyColumn(){

        List<String> tableNameList = modifyColumnMapper.queryTableName();
        for(String tableName : tableNameList){
            //更新表字段默认值
            modifyColumnMapper.upDateDataTime(tableName);
        }
    }

    public void modifyTime(String tableName){



        //总数量
        Long count = modifyColumnMapper.count(tableName);
        //计算总页数
        long totalPage = (count + DEFAULT_PAGE_SIZE - 1) / DEFAULT_PAGE_SIZE;
        int pageNO = 0;
        while (pageNO <totalPage){
            Integer startRow = pageNO * DEFAULT_PAGE_SIZE;
            Integer endRow = (pageNO+1) * DEFAULT_PAGE_SIZE;
            List<MbIndexPO> page = modifyColumnMapper.page(startRow,endRow, tableName);
            for (MbIndexPO mbIndex : page) {
                String publishTime = mbIndex.getPublishTime();
                if(StrUtil.isNotEmpty(publishTime)){
                    long time =  DateUtil.parse(publishTime, DatePattern.NORM_DATETIME_PATTERN).getTime();
                    mbIndex.setDataCreateTime(time);
                    mbIndex.setDataUpdateTime(time);
                }
            }
            modifyColumnMapper.mergeList(page,tableName);
            pageNO ++;
        }
    }

    public void modifyTrigger(){
        List<TriggerPO> triggerList = modifyColumnMapper.triggerList();
        for(TriggerPO trigger : triggerList){
            System.out.printf("触发器:%s%n",trigger.getName());
            if(!"BIN$5t/olSLYQHTgU3MV4gpF5A==$0".equals(trigger.getName())){
                String triggerName = trigger.getOwner() + "."+ trigger.getName();
                modifyColumnMapper.modifyTrigger(triggerName,trigger.getName());
            }


        }
    }

    public void mbDataPage(){
        int count = 0;
        while (true){
            List<MbIndexPO> mbDataPageList = modifyColumnMapper.mbDataPage();
            if(CollUtil.isEmpty(mbDataPageList)){
                break;
            }
            for (MbIndexPO mbIndex : mbDataPageList) {
                String publishTime = mbIndex.getPublishTime();
                if(StrUtil.isNotEmpty(publishTime)){
                    long time =  DateUtil.parse(publishTime, DatePattern.NORM_DATETIME_PATTERN).getTime();
                    mbIndex.setDataCreateTime(time);
                    mbIndex.setDataUpdateTime(time);
                }
            }
            modifyColumnMapper.mergeList(mbDataPageList,"MB_MAIN_DATA");
            count += 10000;
            System.out.println("更新的总数量:"+count);
        }

    }
}
