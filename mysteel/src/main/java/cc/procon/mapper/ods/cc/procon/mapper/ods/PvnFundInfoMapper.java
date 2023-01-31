package cc.procon.mapper.ods;

import cc.procon.model.po.PvnFundInfo;

/**

* ${describe}

*

* 

* @author procon

* @since 2023-01-30

*/
public interface PvnFundInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PvnFundInfo record);

    int insertSelective(PvnFundInfo record);

    PvnFundInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PvnFundInfo record);

    int updateByPrimaryKey(PvnFundInfo record);
}