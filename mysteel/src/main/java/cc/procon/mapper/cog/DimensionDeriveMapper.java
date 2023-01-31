package cc.procon.mapper.cog;

import cc.procon.model.po.DimensionDerivePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author procon
 * @since 2023-01-18
 */
@Mapper
public interface DimensionDeriveMapper {
    @Select("SELECT * FROM T_DAMP_DIMENSION_DERIVE WHERE ID = #{id,jdbcType=VARCHAR} AND IS_DELETE = 0 ")
    DimensionDerivePo getDimensionDeriveById(@Param("id") String id);
}
