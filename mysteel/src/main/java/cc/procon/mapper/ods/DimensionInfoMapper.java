package cc.procon.mapper.ods;


import cc.procon.model.dto.DimensionCommonQueryDTO;
import cc.procon.model.dto.DimensionInfoDTO;
import cc.procon.model.po.DimensionInfoPO;
import cc.procon.model.vo.DimensionFiledVO;
import cc.procon.model.vo.DimensionInfoListVO;
import cc.procon.model.vo.DimensionInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * (DimensionInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-08 15:23:27
 */
@Mapper
public interface DimensionInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DimensionInfoPO queryById(String id);

    /**
     * 查询oracle-ods
     * **/
    DimensionInfoPO queryByTableName(String tableName);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DimensionInfoPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dimensionInfo 实例对象
     * @return 对象列表
     */
    List<DimensionInfoPO> queryAll(DimensionInfoVO dimensionInfo);

    /**
     * 新增数据
     *
     * @param dimensionInfo 实例对象
     * @return 影响行数
     */
    int insert(DimensionInfoDTO dimensionInfo);

    /**
     * 修改数据
     *
     * @param dimensionInfo 实例对象
     * @return 影响行数
     */
    int update(DimensionInfoPO dimensionInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    int selectTotalDimensions(DimensionInfoListVO dimensionInfo);

    List<DimensionInfoPO> queryListData(DimensionInfoListVO dimensionInfo);

    /**
     * 通过ddl创建表
     * @param entities
     * @param tableName
     */
    void createTableByFields(@Param("entities") List<DimensionFiledVO> entities, @Param("tableName") String tableName);

    /**
     * 通过ddl修改表结构
     * @param entity
     * @param tableName
     */
    void addColumnByFields(@Param("entity") DimensionFiledVO entity, @Param("tableName") String tableName);
    void modifyColumnByFields(@Param("entity") DimensionFiledVO entity, @Param("tableName") String tableName);
    String getIndexSeq();
    void addIndexToDimenison(@Param("tableName") String tableName,@Param("indexSeq") String indexSeq);


    int checkTableName(@Param("tableName") String tableName);

    List<String> queryAllIllegalTableName();



    /**
     * 根据条件为dw层提供部分字段查询
     * @return
     */
    List<Map<String,Object>> searchTableInfoByName(Map<String, Object> params);


    /**
     * 获取当前数据库中最新tableCode
     *
     * @return 最新的tableCode
     */
    String getMaxTableCode();



    List<DimensionInfoPO> listByCondition(DimensionCommonQueryDTO dto);



    /**
     * 检查维表是否存在
     */
    @Select("select count(1) from T_DAMP_ODS_DIMENSION_INFO where id = #{id}")
    int checkTableExists(String id);

    /**
     * 查询特定数据表的数据条数
     *
     * @param tableName
     * @return
     */
    int countTableData(@Param("tableName") String tableName);


    /**
     * 根据表名和库名查到维表信息
     *
     * @param tableName 表名
     * @param sourceType 源库
     * @return 维表信息
     * **/
    DimensionInfoPO queryByTableNameAndSourceType(@Param("tableName") String tableName,
                                                  @Param("sourceType") Integer sourceType);

    List<DimensionInfoPO>searchTableInfoByName1(Map<String, Object> params);

    /**
     * 修改表注释及字段注释
     * @param tableName
     * @param tableComments
     */
    void modifyCommentOfTable(@Param("tableName") String tableName, @Param("tableComments") String tableComments);
    void modifyCommentOfField(@Param("entity") DimensionFiledVO entity, @Param("tableName") String tableName);

    /**
     * 根据框架id查询 维表数量
     * @param frameIdList 框架id
     * @return 维表数量
     */
    List<Map<String,Object>> queryCountByFrameIds(@Param("frameIdList") List<String> frameIdList);

}