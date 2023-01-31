package cc.procon.mapper.ods;

import cc.procon.model.po.DimensionDeriveLogPo;
import cc.procon.model.po.PvnNav;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author procon
 * @since 2023-01-18
 */
@Mapper
public interface DimDeriveMapper {

    /**
     * 查询总数量
     * @param tableName 表名
     * @return 结果
     */
    @Select("SELECT count(*) FROM ${tableName} WHERE IS_DELETE = 0 ORDER BY DATA_UPDATE_TIME  ")
    int count(@Param("tableName") String tableName);

    /**
     * 分页查询
     * @param tableName 表名
     * @param startRow 开始时间
     * @param endRow 结束时间
     * @return 查询结果
     */

    List<PvnNav> pageQuery(@Param("tableName") String tableName, @Param("startRow") int startRow, @Param("endRow") int endRow);

    /**
     * 新增数据
     *
     * @param DimensionDeriveLogPo 实例对象
     * @return 影响行数
     */
    @Insert("insert into T_DAMP_DIMENSION_DERIVE_LOG(ID, DERIVE_ID, STATUS, DATA_NUMS, SUCCESS_TIMES, FAIL_TIMES, FAIL_REASON_CONTENT, START_TIME, END_TIME, IS_ENABLE," +
            "IS_DELETE, CREATE_TIME, UPDATE_TIME, CREATE_USER_ID, CREATE_USER_NAME, UPDATE_USER_ID, UPDATE_USER_NAME) VALUES  (#{id},#{deriveId}, #{status}, #{dataNums}, #{successTimes}, #{failTimes}, #{failReasonContent}, #{startTime}, #{endTime}, #{isEnable}, #{isDelete}, #{createTime}, #{updateTime}, #{createUserId}, #{createUserName}, #{updateUserId}, #{updateUserName})")
    int insertLog(DimensionDeriveLogPo DimensionDeriveLogPo);
}
