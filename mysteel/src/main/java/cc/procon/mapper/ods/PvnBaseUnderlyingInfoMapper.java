package cc.procon.mapper.ods;

import cc.procon.model.po.PvnBaseUnderlyingInfo;
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
public interface PvnBaseUnderlyingInfoMapper {
    @Select("SELECT count(*) FROM PVN_BASE_UNDERLYING_INFO WHERE IS_DELETE = 0 ORDER BY ID  ")
    int count();
    List<PvnBaseUnderlyingInfo> pageQuery(@Param("startRow") int startRow, @Param("endRow") int endRow);
}