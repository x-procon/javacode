package cc.procon.mapper.ods;

import cc.procon.model.po.ThsApiFuturesInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 同花顺期货指标信息mapper
 *
 * @author huang
 */
@Mapper
public interface ThsFuturesInfoMapper  {

    /**
     * 批量插入指标信息
     *
     * @param entities
     * @return
     */
    int insertBatchFuturesInfo(@Param("entities") List<ThsApiFuturesInfo> entities);

    /**
     * 插入指标信息
     *
     * @param entities
     * @return
     */
    int insertFuturesInfo(ThsApiFuturesInfo entities);

    /**
     * 根据指标编码查询指标信息是否存在
     *
     * @param indexCode 指标编码
     * @return
     */
    int queryFuturesInfo(@Param("indexCode") String indexCode);

    /**
     * 获取全量的指标信息
     *
     * @return
     */
    List<ThsApiFuturesInfo> listFuturesInfo();

    /**
     * 获取全量的指标(区间指标)信息
     *
     * @return
     */
    List<ThsApiFuturesInfo> listFuturesRangInfo();

    ThsApiFuturesInfo queryFutureInfoByIndexCode(@Param("indexCode") String indexCode);


    /**
     * 查询没有记录的指标编码
     * @return 指标列表
     */
    List<ThsApiFuturesInfo> queryRangeFuturesFromIndex(@Param("start") Integer start, @Param("end") Integer end);
}
