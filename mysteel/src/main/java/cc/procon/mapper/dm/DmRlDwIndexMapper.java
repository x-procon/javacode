package cc.procon.mapper.dm;

import cc.procon.model.po.DmFrameRelationDwIndexPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author procon
 * @since 2022-12-23
 */
@Mapper
public interface DmRlDwIndexMapper {

    /**
     * 查询指标框架
     * @return 结果
     */
    List<String> queryFrameIdList();

    /**
     * 批量更新
     * @param entities 实体类
     * @return 更新结果
     */
    int updateBatch(@Param("entities") List<DmFrameRelationDwIndexPO> entities);

    List<DmFrameRelationDwIndexPO> queryList(@Param("frameId") String frameId);
}
