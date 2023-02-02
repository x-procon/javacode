package cc.procon.mapper.ods;

import cc.procon.model.po.PvnNav;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**

* ${describe}

*

* 

* @author procon

* @since 2023-01-31

*/
public interface PvnNavMapper {
    @Select("SELECT count(*) FROM PVN_NAV WHERE IS_DELETE = 0 ORDER BY ID  ")
    int count();
    List<PvnNav> pageQuery(@Param("startRow") int startRow, @Param("endRow") int endRow);
}