package cc.procon.service;

import cc.procon.mapper.cog.DimensionDeriveMapper;
import cc.procon.mapper.dw.DimDeriveJobMapper;
import cc.procon.mapper.dw.PvnNavMapper;
import cc.procon.mapper.ods.DimDeriveMapper;
import cc.procon.model.dto.DimDerRelationDto;
import cc.procon.model.po.DimensionDeriveLogPo;
import cc.procon.model.po.DimensionDerivePo;
import cc.procon.model.po.PvnNav;
import cc.procon.model.vo.DimDeriveFieldVo;
import cc.procon.model.vo.DimensionDeriveVo;
import cc.procon.util.MD5Util;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 维表衍生Service
 *
 * @author procon
 * @since 2023-01-18
 */
@Slf4j
@Service
public class DimDeriveService {
    @Autowired
    private DimDeriveMapper odsDimDeriveMapper;
    @Autowired
    private DimDeriveJobMapper dwDimDeriveMapper;

    @Autowired
    private DimensionDeriveMapper dimensionDeriveMapper;

    @Autowired
    private PvnNavMapper pvnNavMapper;
    public static final int PAGE_SIZE =3000;

    public void mergeInto(String tableName,String deriveId){

        long currentTimeMillis = System.currentTimeMillis();

        int count = odsDimDeriveMapper.count(tableName);
        //总页数
        int totalPage = (count + PAGE_SIZE -1) / PAGE_SIZE;
        for(int i =0; i< totalPage; i++){
            log.info("共:{}条记录,共:{}页，当前第{}页",count,totalPage,i+1);
            int startRow = i * PAGE_SIZE;
            int endRow = (i + 1) * PAGE_SIZE;
            List<PvnNav> pvnNavList = odsDimDeriveMapper.pageQuery(tableName, startRow, endRow);
            pvnNavList.forEach(e -> {
                e.setOldId(e.getId());
                e.setHtUniqueCode(MD5Util.md5Encode(e.getId()));
            });
            pvnNavMapper.batchInsert(pvnNavList);


            if(i + 1 == totalPage){
                log.info("新增维表衍生日志:{}",deriveId);
                StatLog statLog = new StatLog();
                long endTime = System.currentTimeMillis();
                String logId = UUID.randomUUID().toString().replace("-", "");
                DimensionDeriveLogPo dimensionDeriveLogPo = toLog(logId, deriveId, statLog);
                dimensionDeriveLogPo.setStartTime(currentTimeMillis);
                dimensionDeriveLogPo.setEndTime(endTime);
                dimensionDeriveLogPo.setSuccessTimes(totalPage);
                dimensionDeriveLogPo.setDataNums(count);
            }
        }

    }


    private DimensionDeriveLogPo toLog(String logId, String deriveId, StatLog statLog){
        DimensionDeriveLogPo dimensionDeriveLogPo = new DimensionDeriveLogPo();
        dimensionDeriveLogPo.setId(logId);
        dimensionDeriveLogPo.setDeriveId(deriveId);
        dimensionDeriveLogPo.setCreateTime(System.currentTimeMillis());
        dimensionDeriveLogPo.setCreateUserId(0L);
        dimensionDeriveLogPo.setCreateUserName("SYSINI");
        dimensionDeriveLogPo.setUpdateTime(System.currentTimeMillis());
        dimensionDeriveLogPo.setUpdateUserId(0L);
        dimensionDeriveLogPo.setUpdateUserName("SYSINI");
        dimensionDeriveLogPo.setIsDelete(0);

        if(statLog.getFailTimes()>0){
            dimensionDeriveLogPo.setStatus(0);
        }else {
            dimensionDeriveLogPo.setStatus(1);
        }

        dimensionDeriveLogPo.setDataNums(PAGE_SIZE);
        dimensionDeriveLogPo.setSuccessTimes(10);
        dimensionDeriveLogPo.setFailTimes(0);
        dimensionDeriveLogPo.setFailReasonContent("");
        dimensionDeriveLogPo.setIsEnable(1);

        return dimensionDeriveLogPo;
    }

    @Data
    private class StatLog {
        private Integer dataNums = 0;
        private Integer successTimes = 0;
        private Integer failTimes = 0;
        private Set<String> failReasonContents = new HashSet<>();

    }

    public static DimensionDeriveVo toVo(DimensionDerivePo dimensionDerivePo){
        DimensionDeriveVo dimensionDeriveVo = new DimensionDeriveVo();


        BeanUtils.copyProperties(dimensionDerivePo,dimensionDeriveVo);

        if(StringUtils.isNotEmpty(dimensionDerivePo.getRelation())){
            List<DimDerRelationDto> relationVos = JSONArray.parseArray(dimensionDerivePo.getRelation(), DimDerRelationDto.class);
            dimensionDeriveVo.setRelation(relationVos);
        }

        if(StringUtils.isNotEmpty(dimensionDerivePo.getDeriveUnique())){
            List<DimDeriveFieldVo> uniques = JSONArray.parseArray(dimensionDerivePo.getDeriveUnique(), DimDeriveFieldVo.class);

            dimensionDeriveVo.setDeriveUnique(uniques);
        }

        return dimensionDeriveVo;
    }

    private List<Map<String,Object>> convertData(List<Map<String,Object>> batch,List<DimDerRelationDto> relations,List<String> unique){

        Map<String,Map<String,Object>> dataGroup = new HashMap<>();


        batch.forEach(source->{
            Map<String, Object> target = new HashMap<>();

            relations.forEach(rel -> target.put(rel.getTargetField().toUpperCase(), StringUtils.isEmpty(rel.getRelSource())?null:source.get(rel.getRelSource().toUpperCase())));

            String mapKey = UUID.randomUUID().toString().replace("-","");
            //有唯一约束按唯一约束去重
            if(!CollectionUtils.isEmpty(unique)){
                mapKey = mapKey(target, unique);
                //设置唯一约束的值
                target.put("HT_UNIQUE_CODE", MD5Util.md5Encode(mapKey));
            }

            dataGroup.put(mapKey,target);
        });
        return new ArrayList<>(dataGroup.values());
    }

    private String mapKey(Map<String, Object> map, List<String> unique){
        return unique.stream().map(f-> Objects.isNull(map.get(f))?"":map.get(f).toString()).collect(Collectors.joining());
    }
}
