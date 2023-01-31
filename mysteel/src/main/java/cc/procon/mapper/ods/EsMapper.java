package cc.procon.mapper.ods;

import cc.procon.model.po.PvnPersonnelInfo;
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

    @Select("SELECT count(*) FROM PVN_PERSONNEL_INFO WHERE IS_DELETE = 0 ORDER BY PERSONNEL_ID  ")
    int count();
    List<PvnPersonnelInfo> pageQuery(@Param("startRow") int startRow, @Param("endRow") int endRow);
}
