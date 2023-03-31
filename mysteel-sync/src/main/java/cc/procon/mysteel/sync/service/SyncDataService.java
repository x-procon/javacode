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

    public void indexFrameDataSync(Integer pid){
        List<MbDfMetadata0001> mbDfMetadata0001List = scMapper.selectChildrenFrameByParentId(pid);
        List<List<MbDfMetadata0001>> partition = Lists.partition(mbDfMetadata0001List, 3000);
        log.info("开始导入框架信息");
        for (List<MbDfMetadata0001> mbDfMetadata0001s : partition) {
            iirpMapper.indexFrameBatchInsert(mbDfMetadata0001s);
            //导入指标信息

        }
        log.info("开始导入指标信息");
        //导入指标信息
        List<Long> collect = mbDfMetadata0001List.stream().map(MbDfMetadata0001::getFrameId).toList();
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


    public void indexDataSync(){
        List<MbDfMetadata0001> mbDfMetadata0001List = iirpMapper.queryAllIndexFrame();
        List<Long> collect = mbDfMetadata0001List.stream().map(MbDfMetadata0001::getFrameId).toList();
        List<List<Long>> partition = Lists.partition(collect, 500);


    }
}
