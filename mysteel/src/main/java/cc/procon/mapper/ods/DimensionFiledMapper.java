package cc.procon.mapper.ods;


import cc.procon.model.po.DimensionFiledPO;
import cc.procon.model.vo.DimensionFiledVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (DimensionFiled)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-08 14:57:41
 */

@Mapper
public interface DimensionFiledMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DimensionFiledPO queryById(String id);
    List<DimensionFiledPO>queryByIds(@Param("ids") List<String>ids);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DimensionFiledPO queryByTableIdAndName(@Param("id") String id, @Param("name")String name);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DimensionFiledPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dimensionFiled 实例对象
     * @return 对象列表
     */
    List<DimensionFiledPO> queryAll(DimensionFiledVO dimensionFiled);

    /**
     * 新增数据
     *
     * @param dimensionFiled 实例对象
     * @return 影响行数
     */
    int insert(DimensionFiledPO dimensionFiled);

    /**
     * 修改数据
     *
     * @param dimensionFiled 实例对象
     * @return 影响行数
     */
    int update(DimensionFiledPO dimensionFiled);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

    /**
     * 根据条件为dw层提供部分字段查询
     * @return
     */
    List<Map<String,Object>> searchTableFiledByTableId(Map<String, Object> params);
    List<Map<String,Object>> searchTableFiledByTableId1(Map<String, Object> params);

    /**
     * 检查字段是否存在
     */

    int checkFiledExists(@Param("tableId") String tableId, @Param("id") String id, @Param("filedType") String filedType);


    List<Map<String, Object>> getDistinctDataOfByParams(Map<String,Object> params);

    /**
     * 根据表名查字段
     * @param tableName
     * @return
     */
    List<DimensionFiledPO> queryFieldsByTableName(@Param("tableName") String tableName);

    /**
     * 根据表名和来源查字段
     * @param tableName
     * @return
     */
    List<DimensionFiledPO> queryFieldsByTableNameBySourceType(@Param("tableName") String tableName,@Param("sourceType") Long sourceType);

    /**
     * 根据表id查询维表字段
     * @param tableId 表id
     * @return 字段信息
     */
    List<DimensionFiledPO> queryByTableId(@Param("tableId") String tableId);

    List<DimensionFiledPO> queryTabColsByTableName(@Param("tableName") String tableName);
}