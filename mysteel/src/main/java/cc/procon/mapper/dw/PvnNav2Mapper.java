package cc.procon.mapper.dw;

import cc.procon.model.po.PvnNav;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

* ${describe}

*

* 

* @author procon

* @since 2023-01-18

*/
public interface PvnNav2Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(PvnNav record);

    int insertSelective(PvnNav record);

    PvnNav selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PvnNav record);

    int updateByPrimaryKey(PvnNav record);

    void mergeInto(@Param("list") List<PvnNav> records);

    void batchInsert(@Param("list") List<PvnNav> records);
}