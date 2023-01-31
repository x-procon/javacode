package cc.procon.model.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ${describe}
 *
 * @author procon
 * @since 2023-01-29
 */
@Data
public class PvnNav {
    private String id;

    private String oldId;

    private String fundId;

    private BigDecimal nav;

    private BigDecimal cumulativeNav;

    private BigDecimal ishighOrLow;

    private BigDecimal tohighNavRatio;

    private BigDecimal isvalid;

    private Date updatetime;

    private Date priceDate;

    private BigDecimal cumulativeNavWithdrawal;

    private Date createtime;

    private String htUniqueCode;

    private Integer isDelete;

    private Integer isQuality;

    private Long dataCreateTime;

    private Long dataUpdateTime;
}