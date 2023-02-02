package cc.procon.mapper.ods;

import cc.procon.model.po.PvnPersonnelCompanyMapping;
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
public interface PvnPersonnelCompanyMappingMapper {
    @Select("SELECT count(*) FROM PVN_PERSONNEL_COMPANY_MAPPING WHERE IS_DELETE = 0 ORDER BY ID  ")
    int count();
    List<PvnPersonnelCompanyMapping> pageQuery(@Param("startRow") int startRow, @Param("endRow") int endRow);
}