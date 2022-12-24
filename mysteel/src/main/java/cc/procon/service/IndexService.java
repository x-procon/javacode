package cc.procon.service;

import cc.procon.mapper.dm.DmRlDwIndexMapper;
import cc.procon.mapper.dw.DwIndexMapper;
import cc.procon.model.po.DmFrameRelationDwIndexPO;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author procon
 * @since 2022-12-23
 */
@Slf4j
@Service
public class IndexService {
    @Autowired
    private DmRlDwIndexMapper dmRlDwIndexMapper;
    @Autowired
    private DwIndexMapper dwIndexMapper;

    public void updateIndexSort(){
        List<String> frameIdList = dmRlDwIndexMapper.queryFrameIdList();
        for (int i=0;i<frameIdList.size();i++) {
            log.info("共{}个框架，现在处理第{}个",frameIdList.size(),i+1);
            String frameId = frameIdList.get(i);
            List<DmFrameRelationDwIndexPO> dmIndexList = dmRlDwIndexMapper.queryList(frameId);
            List<String> indexIdList = new ArrayList<>();
            dmIndexList.forEach(e -> indexIdList.add(e.getIndexId()));
            List<List<String>> indexIdListPartition = Lists.partition(indexIdList, 900);
            List<String> indexIdSortList = new ArrayList<>();
            for (List<String> indexIds : indexIdListPartition) {
                List<String> byIndexIds = dwIndexMapper.findByIndexIds(indexIds);
                indexIdSortList.addAll(byIndexIds);
            }

            for (int j = 0; j < indexIdSortList.size(); j++) {
                String indexId = indexIdSortList.get(j);
                int finalJ = j;
                dmIndexList.forEach(e -> {
                    if(indexId.equals(e.getIndexId())){
                        e.setSort(finalJ +1);
                    }
                });
            }
            List<List<DmFrameRelationDwIndexPO>> partition = Lists.partition(dmIndexList, 900);
            for (List<DmFrameRelationDwIndexPO> dmFrameRelationDwIndexList : partition) {
                dmRlDwIndexMapper.updateBatch(dmFrameRelationDwIndexList);
            }

        }
        
    }
}
