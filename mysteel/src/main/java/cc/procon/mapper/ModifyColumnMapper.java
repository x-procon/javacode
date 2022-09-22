package cc.procon.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 元数据采集任务表V2(MetadataTaskPO)表数据库访问层
 *
 * @author chenan
 * @since 2022-05-10 13:58:37
 */
@Mapper
public interface ModifyColumnMapper {

    /**
     * 通过ID查询单条数据
     *
     *
     * @return 实例对象
     */
    @Select(" SELECT TABLE_NAME FROM USER_TAB_COLUMNS WHERE  COLUMN_NAME = 'DATA_CREATE_TIME' AND DATA_TYPE = 'NUMBER'")
    List<String> queryTableName();

    @Update("  alter table ${tableName} modify DATA_CREATE_TIME DEFAULT  (SYSDATE - TO_DATE('1970-1-1 8' , 'YYYY-MM-DD HH24'))  * 86400000 + TO_NUMBER(TO_CHAR(SYSTIMESTAMP(3), 'FF')) ")
    void upDateDataTime(@Param("tableName") String tableName);

}