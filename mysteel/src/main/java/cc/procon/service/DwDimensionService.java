package cc.procon.service;

import cc.procon.mapper.dw.DwDimensionFiledMapper;
import cc.procon.mapper.dw.DwDimensionInfoMapper;
import cc.procon.model.po.DimensionFiledPO;
import cc.procon.model.po.DimensionInfoPO;
import cc.procon.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author procon
 * @since 2023-03-08
 */
@Service
public class DwDimensionService {
    @Autowired
    private DwDimensionInfoMapper dimensionInfoMapper;

    @Autowired
    private DwDimensionFiledMapper dimensionFiledMapper;

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
