package cc.procon.mapper.dw;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 维表衍生Mapper
 *
 * @author procon
 * @since 2023-01-18
 */
@Mapper
public interface DimDeriveJobMapper {
    /**
     * 更新或插入
     * @param tableName 表名
     * @param fields 字段名
     * @param data 数据
     * @param unique 唯一
     * @param mergeFields 更新的字段
     */
    void mergeInto(@Param("tableName") String tableName,
                   @Param("fields") List<String> fields,
                   @Param("data") List<Map<String,Object>> data,
                   @Param("unique") List<String> unique,
                   @Param("mergeFields") List<String> mergeFields);

    void insertInto(@Param("tableName") String tableName,
                    @Param("fields") List<String> fields,
                    @Param("data") List<Map<String,Object>> data);
}
