package cc.procon.mapper.dw;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface DimIncrMapper {

    /**
     * 新增或者更新
     * @param tableName 表名
     * @param minUpdateTime 最小更新时间
     * @param sourceType 来源 1：oracle
     */
    void insertOrUpdate (@Param("tableName") String tableName,
                         @Param("minUpdateTime") Long minUpdateTime,
                         @Param("sourceType") Integer sourceType);
}
