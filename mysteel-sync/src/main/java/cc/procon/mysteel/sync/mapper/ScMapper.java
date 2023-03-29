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
@DS("sc")
@Mapper
public interface ScMapper {
    /**
     * 根据pid查询子级框架
     * @param pid 父级id
     * @return 结果
     */
    List<MbDfMetadata0001> selectChildrenFrameByParentId(@Param("pid") Integer pid);

    /**
     * 查询所有跟节点
     * @param pid 父级id
     * @return 结果
     */
    List<MbDfMetadata0001> selectAllBottomFrameByParentId(@Param("pid") Integer pid);


    List<MbDfMetadata0002> selectAllIndexByFrameList(@Param("frameIds") List<Long> frameIds);


}
