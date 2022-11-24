package cc.procon.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: integrator-api
 * @description: 同花顺时间序列期货指标表实体类
 * @author: huang
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThsApiFuturesInfo implements Serializable {

    private static final long serialVersionUID = -3722386004954682822L;
    /**
     * 指标编码-主键
     */
    private String indexCode;

    /**
     * 证券类型
     */

    private Long bondType;

    /**
     * 交易所名称
     */

    private String exchangeName;

    /**
     * 品种名称
     */

    private String breedName;

    /**
     * 合约编码
     */
    private String contractCode;

    /**
     * 指标分类
     */
    private String indexClassify;

    /**
     * 指标中文名称
     */
    private String indexCnName;

    /**
     * 指标英文名称
     */
    private String indexEnName;

    /**
     * 指标描述
     */
    private String indexCnMarks;

    /**
     * hbase索引
     */
    private String htUniqueCode;

    /**
     * 是否有效
     */
    private Long isDelete;

    /**
     * 是否质检
     */
    private Long isQuality;

    /**
     * 数据创建时间
     */
    private Long dataCreateTime;

    /**
     * 数据更新时间
     */
    private Long dataUpdateTime;
}
