package cc.procon.service;

import cc.procon.mapper.ods.DimensionFiledMapper;
import cc.procon.mapper.ods.DimensionInfoMapper;
import cc.procon.model.po.DimensionFiledPO;
import cc.procon.model.po.DimensionInfoPO;
import cc.procon.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * ods维表service
 *
 * @author procon
 * @since 2023-03-07
 */
@Service
@Slf4j
public class OdsDimensionInfoService {

    @Autowired
    private DimensionInfoMapper dimensionInfoMapper;

    @Autowired
    private DimensionFiledMapper dimensionFiledMapper;

    @Transactional(rollbackFor = Exception.class)
    public void updateDimensionInfo(String tableName){
        DimensionInfoPO dimensionInfoPO = dimensionInfoMapper.queryByTableName(tableName);
        if(Objects.isNull(dimensionInfoPO)){
            return;
        }
        List<DimensionFiledPO> filedPOList = dimensionFiledMapper.queryTabColsByTableName(tableName);
        for(DimensionFiledPO dimensionFiled: filedPOList){
            if(dimensionFiled.getCnName().length()>50){
                String substring = dimensionFiled.getCnName().substring(0, 50);
                dimensionFiled.setCnName(substring);
            }
            dimensionFiled.setIsEnable(1);
            if("NUMBER".equalsIgnoreCase(dimensionFiled.getDataType()) && Objects.isNull(dimensionFiled.getDataAccuracy())){
                dimensionFiled.setDataAccuracy(0);
            }
            DimensionFiledPO dimensionFiledPO = dimensionFiledMapper.queryByTableIdAndName(dimensionInfoPO.getId(), dimensionFiled.getName());
            if(Objects.isNull(dimensionFiledPO)){
                String id = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
                dimensionFiled.setId(id);
                dimensionFiled.setTableId(dimensionInfoPO.getId());
                dimensionFiledMapper.insert(dimensionFiled);
            }else {
                dimensionFiled.setId(dimensionFiledPO.getId());
                dimensionFiled.setTableId(dimensionFiledPO.getTableId());
                dimensionFiledMapper.update(dimensionFiled);
            }
        }

       dimensionInfoPO.setTableFileds(JsonUtils.toString(filedPOList));
        dimensionInfoMapper.update(dimensionInfoPO);




    }
}
