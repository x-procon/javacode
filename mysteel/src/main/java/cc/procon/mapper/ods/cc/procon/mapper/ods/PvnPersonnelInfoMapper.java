package cc.procon.mapper.ods;

import cc.procon.model.po.PvnPersonnelInfo;import org.apache.ibatis.annotations.Param;

/**
 * ${describe}
 *
 * @author procon
 * @since 2023-01-30
 */
public interface PvnPersonnelInfoMapper {
    int deleteByPrimaryKey(String personnelId);

    int insert(PvnPersonnelInfo record);

    int insertSelective(PvnPersonnelInfo record);

    PvnPersonnelInfo selectByPrimaryKey(String personnelId);

    int updateByPrimaryKeySelective(PvnPersonnelInfo record);

    int updateByPrimaryKey(PvnPersonnelInfo record);

    int deleteByPrimaryKey(@Param("id") String id, @Param("personnelId") String personnelId);

    PvnPersonnelInfo selectByPrimaryKey(@Param("id") String id, @Param("personnelId") String personnelId);
}