package cc.procon.service;

import cc.procon.elasticsearch.ElasticSearchService;
import cc.procon.mapper.dw.DwDimensionMapper;
import cc.procon.model.dto.IndexInitRequest;
import cc.procon.model.po.ColumnPO;
import cc.procon.model.po.IndexInfoPO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author procon
 * @since 2023-02-03
 */
@Service
@Slf4j
public class EsService {

    @Autowired
    private DwDimensionMapper dwDimensionMapper;

    @Autowired
    private ElasticSearchService elasticSearchService;

    public void createEsIndex(IndexInitRequest req) {
        log.info("初始化维表信息：" + req);
        try {
            if (StringUtils.isEmpty(req.getTableName()) && StringUtils.isEmpty(req.getId())) {
                return ;
            }
            IndexInfoPO indexInfo = dwDimensionMapper.getDwDimension(req.getTableName());
            if (indexInfo == null || StringUtils.isEmpty(indexInfo.getTableName())) {
                log.error("索引名称不能为空" + req);
                return ;
            }
            req.setTableName(req.getTableName().toLowerCase());
            initMap(indexInfo, req);
            List<ColumnPO> columnList = indexInfo.getColumnList();
            ColumnPO col1 = new ColumnPO("IS_DELETE","NUMBER");
            ColumnPO col2 = new ColumnPO("IS_QUALITY","NUMBER");
            ColumnPO col3 = new ColumnPO("DATA_CREATE_TIME","NUMBER");
            ColumnPO col4 = new ColumnPO("DATA_UPDATE_TIME","NUMBER");
            ColumnPO col5 = new ColumnPO("HT_UNIQUE_CODE","NVARCHAR2");
            columnList.add(col1);
            columnList.add(col2);
            columnList.add(col3);
            columnList.add(col4);
            columnList.add(col5);
            elasticSearchService.deleteIndex(req.getTableName());
            elasticSearchService.createEsIndex(indexInfo);
        } catch (Exception e) {
            log.error("初始化同步异常" + req, e);
        }
    }

    private void initMap(IndexInfoPO info, IndexInitRequest req) {
        List<ColumnPO> columnList = JSON.parseArray(info.getTableFileds(), ColumnPO.class);
        info.setColumnList(columnList);
        StringBuffer sb = new StringBuffer("");
        for (ColumnPO column : columnList) {
            sb.append(",").append(column.getName());
        }
        List<String> columsList = new ArrayList<>();
        List<String> columsStr = columnList.stream().map(x -> x.getName()).collect(Collectors.toList());

        columsList = Arrays.asList("IS_DELETE", "IS_QUALITY", "DATA_CREATE_TIME", "DATA_UPDATE_TIME", "HT_UNIQUE_CODE");


        columsList.forEach(x -> {
            if (!columsStr.contains(x)) {
                sb.append(",").append(x);
            }
        });
        req.setColumns(sb.substring(1));
    }



}
