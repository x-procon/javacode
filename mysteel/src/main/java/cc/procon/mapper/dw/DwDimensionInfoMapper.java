package cc.procon.mapper.dw;


import cc.procon.model.dto.DimensionCommonQueryDTO;
import cc.procon.model.dto.DimensionInfoDTO;
import cc.procon.model.po.DimensionInfoPO;
import cc.procon.model.vo.DimensionFiledVO;
import cc.procon.model.vo.DimensionInfoListVO;
import cc.procon.model.vo.DimensionInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (DimensionInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-08 15:23:27
 */
@Mapper
public interface DwDimensionInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DimensionInfoPO queryById(String id);

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

    /**
     * 条件查询数据总条数
     *
     * @param dimensionInfo
     * @return
     */
    int selectTotalDimensions(DimensionInfoListVO dimensionInfo);

    /**
     * 条件查询列表
     *
     * @param dimensionInfo
     * @return
     */
    List<DimensionInfoPO> queryListData(DimensionInfoListVO dimensionInfo);

    /**
     * 通过ddl创建表
     * @param entities
     * @param tableName
     */
    void createTableByFields(@Param("entities") List<DimensionFiledVO> entities, @Param("tableName") String tableName);
    String getIndexSeq();
    void addIndexToDimenison(@Param("tableName") String tableName,@Param("indexSeq") String indexSeq);

    /**
     * 通过ddl修改表结构
     *
     * @param entity
     * @param tableName
     */
    void addColumnByFields(@Param("entity") DimensionFiledVO entity, @Param("tableName") String tableName);

    /**
     * 通过ddl修改表结构
     *
     * @param entity
     * @param tableName
     */
    void modifyColumnByFields(@Param("entity") DimensionFiledVO entity, @Param("tableName") String tableName);

    /**
     * 检查表名是否使用Oracle保留字
     *
     * @param tableName
     * @return 返回值 > 0 存在同名
     */
    int checkTableName(@Param("tableName") String tableName);

    List<String> queryAllIllegalTableName();



    /**
     * 获取当前数据库中最新tableCode
     *
     * @return 最新的tableCode
     */
    String getMaxTableCode();

    /**
     * 根据框架id查询关联维表的总数
     *
     * @param dto
     * @return
     */
    int countByCondition(DimensionCommonQueryDTO dto);

    /**
     * 根据框架id查询关联维表集合
     *
     * @param dto
     * @return
     */
    List<DimensionInfoPO> pageByCondition(DimensionCommonQueryDTO dto);

    /**
     * 根据框架id查询关联维表集合
     *
     * @param dto
     * @return
     */
    List<DimensionInfoPO> listByCondition(DimensionCommonQueryDTO dto);

    List<String> listIdByCondition(DimensionCommonQueryDTO dto);

    List<DimensionInfoPO> listSimpleByCondition(DimensionCommonQueryDTO dto);

    /**
     * 查询特定数据表的数据条数
     *
     * @param tableName
     * @return
     */
    int countTableData(@Param("tableName") String tableName);



    /**
     * 根据条件为dw层提供部分字段查询
     * @return
     */
    List<DimensionInfoPO> searchTableInfoByName(Map<String, Object> params);



    /**
     * 根据表名和库名查到维表信息
     *
     * @param tableName 表名
     * @param sourceType 源库
     * @return 维表信息
     * **/
    DimensionInfoPO queryByTableNameAndSourceType(@Param("tableName") String tableName,
                                                  @Param("sourceType") Integer sourceType);

    /**
     * 修改表注释及字段注释
     * @param tableName
     * @param tableComments
     */
    void modifyCommentOfTable(@Param("tableName") String tableName, @Param("tableComments") String tableComments);
    void modifyCommentOfField(@Param("entity") DimensionFiledVO entity, @Param("tableName") String tableName);




    /**
     * Dm层根据查询维表总数
     * @param dto 请求参数
     * @return 维表总数
     */
    int countDmByCondition(DimensionCommonQueryDTO dto);

    /**
     * 根据框架id查询DM层框架关联维表集合
     *
     * @param dto 请求参数
     * @return 维表集合（可重复）
     */
    List<DimensionInfoPO> pageDmDimensionByCondition(DimensionCommonQueryDTO dto);


}