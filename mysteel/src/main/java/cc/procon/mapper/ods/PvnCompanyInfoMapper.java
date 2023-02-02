package cc.procon.mapper.ods;

import cc.procon.model.po.PvnCompanyInfo;
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
public interface PvnCompanyInfoMapper {
    @Select("SELECT count(*) FROM PVN_COMPANY_INFO WHERE IS_DELETE = 0 ORDER BY COMPANY_ID  ")
    int count();
    List<PvnCompanyInfo> pageQuery(@Param("startRow") int startRow, @Param("endRow") int endRow);
}