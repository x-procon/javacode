package cc.procon.mapper.ods;

import cc.procon.model.po.ThsApiFuturesData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 同花顺期货指标数据mapper
 *
 * @author huang
 */
@Mapper
public interface ThsFuturesDataMapper {




    /**
     * 查询指标数据的最大时间
     *
     * @param indexCode 指标编码
     * @return
     */
    ThsApiFuturesData queryFuturesMaxDate(@Param("indexCode") String indexCode);

    /**
     * 插入指标数据
     *
     * @param entities
     * @return
     */
    int insertFuturesData(ThsApiFuturesData entities);

    /**
     * 根据指标编码查询指标信息是否存在
     *
     * @param entities 指标编码
     * @return
     */
    ThsApiFuturesData queryFuturesData(ThsApiFuturesData entities);

    /**
     * 更新指标数据
     *
     * @param entities
     * @return
     */
    int updateFuturesData(ThsApiFuturesData entities);

    /**
     * 更新或新增指标数据
     * @param entities 列表
     * @return 结果
     */
    int mergeDataList(@Param("entities")  List<ThsApiFuturesData> entities);

}
