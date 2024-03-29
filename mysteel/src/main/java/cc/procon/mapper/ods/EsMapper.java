package cc.procon.mapper.ods;

import cc.procon.model.po.PvnFundRiskadjretStats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author procon
 * @since 2023-01-29
 */
@Mapper
public interface EsMapper {

    @Select("SELECT count(*) FROM PVN_FUND_RISKADJRET_STATS WHERE IS_DELETE = 0 ORDER BY ID  ")
    int count();
    List<PvnFundRiskadjretStats> pageQuery(@Param("startRow") int startRow, @Param("endRow") int endRow);
}
