package cc.procon.mapper.ods;


import cc.procon.model.po.MbIndexPO;
import cc.procon.model.po.TriggerPO;
import org.apache.ibatis.annotations.*;

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

    @Select("  SELECT TABLE_NAME FROM user_tables WHERE  TABLE_NAME LIKE #{tableName} ")
    List<String> queryTableNameByName(@Param("tableName") String tableName);

    @Select(" SELECT MS_ID msId, INDEX_CODE indexCode,DATA_DATE dataDate,PUBLISH_TIME publishTime,DATA_CREATE_TIME dataCreateTime,DATA_UPDATE_TIME dataUpdateTime FROM ${tableName} a WHERE ( a.INDEX_CODE, a.DATA_DATE ) IN ( SELECT INDEX_CODE, DATA_DATE FROM  ${tableName} GROUP BY INDEX_CODE, DATA_DATE  HAVING count( * ) > 1 )")
    List<MbIndexPO> getAllRepeatIndex(@Param("tableName") String tableName);

    @Insert("UPDATE ${tableName} SET DATA_CREATE_TIME = #{param2.dataCreateTime},DATA_UPDATE_TIME = #{param2.dataUpdateTime} WHERE MS_ID = #{param2.msId} AND INDEX_CODE = #{param2.indexCode} AND DATA_DATE = #{param2.dataDate}")
    void update(@Param("tableName") String tableName,MbIndexPO mbIndexPO);

    //
    void mergeList(List<MbIndexPO> mbIndexList,@Param("tableName") String tableName);

    @Select(" SELECT COUNT(*) FROM ${tableName} a WHERE ( a.INDEX_CODE, a.DATA_DATE ) IN ( SELECT INDEX_CODE, DATA_DATE FROM ${tableName} WHERE  IS_DELETE = 0 GROUP BY INDEX_CODE, DATA_DATE HAVING count( * ) > 1 )")
    Long count(@Param("tableName") String tableName);


    @Select(" SELECT MS_ID msId,INDEX_CODE indexCode,DATA_DATE dataDate,PUBLISH_TIME publishTime,DATA_CREATE_TIME dataCreateTime,DATA_UPDATE_TIME dataUpdateTime  " +
            "FROM (SELECT tt.*,ROWNUM AS rowno FROM(SELECT t.* FROM ${tableName} t WHERE ( t.INDEX_CODE, t.DATA_DATE ) IN ( SELECT INDEX_CODE, DATA_DATE FROM ${tableName} WHERE IS_DELETE = 0 GROUP BY INDEX_CODE, DATA_DATE HAVING count( * ) > 1 ) ORDER BY MS_ID ) tt WHERE ROWNUM <= #{endRow} ) table_alias WHERE table_alias.rowno >= #{startRow}")
    List<MbIndexPO> page(@Param("startRow")Integer startRow,@Param("endRow")Integer endRow,@Param("tableName")String tableName);

    @Select(" SELECT * FROM all_source where type='TRIGGER' and   TEXT LIKE '%SELECT (sysdate-to_date%' ORDER BY NAME ")
    List<TriggerPO> triggerList();


    void modifyTrigger(@Param("triggerName") String triggerName,@Param("name") String name);


    @Select("SELECT MS_ID msId,INDEX_CODE indexCode,DATA_DATE dataDate,PUBLISH_TIME publishTime,DATA_CREATE_TIME dataCreateTime,DATA_UPDATE_TIME dataUpdateTime FROM  (  SELECT A.*, ROWNUM RN  FROM (SELECT * FROM MB_INDEX_MAIN_DATA WHERE DATA_UPDATE_TIME IS NULL) A  WHERE ROWNUM <= 10000 )  WHERE RN > 0")
    List<MbIndexPO> mbDataPage();
}