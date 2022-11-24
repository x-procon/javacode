package cc.procon.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author huang
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThsApiFuturesData implements Serializable {

    private static final long serialVersionUID = -3420515155224487086L;
    /**
     * 数据主键
     */

    private String indexCode;

    /**
     * 指标编码
     */

    private String indexValue;

    /**
     * 指标值所属日期
     */

    private Date indexValueTime;

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