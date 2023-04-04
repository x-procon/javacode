package cc.procon.mysteel.sync.mapper;

import cc.procon.mysteel.sync.model.MbDfMetadata0001;
import cc.procon.mysteel.sync.model.MbDfMetadata0002;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author procon
 * @since 2023-03-29
 */

@Mapper
@DS("iirp")
public interface IirpMapper {
    /**
     * 指标框架批量插入
     * @param list 列表
     * @return 结果
     */
    int indexFrameBatchInsert(@Param("list") List<MbDfMetadata0001> list);

    /**
     * 指标批量插入
     * @param list 列表
     * @return 结果
     */
    int indexBatchInsert(@Param("list") List<MbDfMetadata0002> list);


    /**
     * 查询所有框架
     * @return 杰哥
     */
    List<Long> queryAllIndexFrame();
}


