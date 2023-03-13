package cc.procon.mapper.dw;


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
public interface DwDimensionFiledMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DimensionFiledPO queryById(String id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DimensionFiledPO queryByTableIdAndName(@Param("id") String id, @Param("name") String name);

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
     * 根据表名查字段
     * @param tableName
     * @return
     */
    List<DimensionFiledPO> queryFieldsByTableName(@Param("tableName") String tableName);



    List<Map<String,Object>> searchTableFiledByTableId(Map<String, Object> params);


    List<DimensionFiledPO> queryTabColsByTableName(@Param("tableName") String tableName);
}