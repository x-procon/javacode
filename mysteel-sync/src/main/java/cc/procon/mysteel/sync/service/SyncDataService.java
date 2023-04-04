package cc.procon.mysteel.sync.service;

import cc.procon.mysteel.sync.mapper.IirpMapper;
import cc.procon.mysteel.sync.mapper.ScMapper;
import cc.procon.mysteel.sync.model.MbDfMetadata0001;
import cc.procon.mysteel.sync.model.MbDfMetadata0002;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author procon
 * @since 2023-03-29
 */
@Slf4j
@Service
public class SyncDataService {

    @Autowired
    private IirpMapper iirpMapper;

    @Autowired
    private ScMapper scMapper;

    public void indexFrameDataSync(){
        List<MbDfMetadata0001> mbDfMetadata0001s1 = scMapper.selectParentFrame();
        iirpMapper.indexFrameBatchInsert(mbDfMetadata0001s1);
        if(!CollectionUtils.isEmpty(mbDfMetadata0001s1)){
            for (MbDfMetadata0001 mbDfMetadata0001 : mbDfMetadata0001s1) {
                log.info("开始导入一级目录为:{}的数据",mbDfMetadata0001.getCnName());
                List<MbDfMetadata0001> mbDfMetadata0001List = scMapper.selectChildrenFrameByParentId(mbDfMetadata0001.getFrameId());
                List<List<MbDfMetadata0001>> partition = Lists.partition(mbDfMetadata0001List, 3000);
                log.info("开始导入框架信息");
                for (List<MbDfMetadata0001> mbDfMetadata0001s : partition) {
                    iirpMapper.indexFrameBatchInsert(mbDfMetadata0001s);
                }
            }
        }
        log.info("开始导入指标信息");
        //导入指标信息
        List<Long> collect = iirpMapper.queryAllIndexFrame();
        List<List<Long>> partition1 = Lists.partition(collect, 500);
        for (List<Long> frameIds : partition1) {
            List<MbDfMetadata0002> mbDfMetadata0002s = scMapper.selectAllIndexByFrameList(frameIds);
            if (!CollectionUtils.isEmpty(mbDfMetadata0002s)) {
                int sum = 0;
                List<List<MbDfMetadata0002>> partition2 = Lists.partition(mbDfMetadata0002s, 3000);
                for (List<MbDfMetadata0002> mbDfMetadata0002s1 : partition2) {
                    int j = iirpMapper.indexBatchInsert(mbDfMetadata0002s1);
                    sum += j;
                }
                log.info("共导入指标{}个", sum);
            }
        }

    }


}
