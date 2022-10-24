package cc.procon.mapper;

import cc.procon.model.po.SMMIndexDataPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 上海有色mapper
 * @author procon
 * @since 2022-10-12
 */

@Mapper
public interface SMMIndexMapper {

    /**
     * 查询所有指标id
     * @return 指标id列表
     */
    @Select("SELECT QUOTA_ID FROM SMM_API_INDEX_INFO WHERE IS_DELETE = 0 AND QUOTA_ID NOT LIKE 'i800%' order by QUOTA_ID")
    List<String> selectAllQuotaId();

    /**
     * 批量更新或删除
     * @param recordList 记录list
     * @return 结果
     */
    int mergeList (List<SMMIndexDataPO> recordList);
}
