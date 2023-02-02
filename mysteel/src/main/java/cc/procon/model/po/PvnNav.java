package cc.procon.model.po;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * ${describe}
 *
 * @author procon
 * @since 2023-01-31
 */
@Data
public class PvnNav {
    /**
     * ID
     */
    private Long id;

    /**
     * 基金ID，'HF'开头(后加36进制编码格式,不足8位长度左补零） 例：HF00000001
     */
    private String fundId;

    /**
     * 净值日期
     */
    private Date priceDate;

    /**
     * 单位净值
     */
    private BigDecimal nav;

    /**
     * 考虑分红再投资的单位累计净值
     */
    private BigDecimal cumulativeNav;

    /**
     * 分红不投资的单位累计净值
     */
    private BigDecimal cumulativeNavWithdrawal;

    /**
     * 净值创新高或新低标志；1-创历史新高；2-创历史新低；3-既没有创历史新高也没有创历史新低;-1-其他
     */
    private Long ishighOrLow;

    /**
     * 距离历史新高的距离，（历史最高累计净值-最新累计净值）*100%/最新累计净值
     */
    private BigDecimal tohighNavRatio;

    /**
     * 创建者ID,默认第一次创建者名称，创建后不变更
     */
    private Long creatorid;

    /**
     * 创建时间,默认第一次创建的GETDATE()时间
     */
    private Date createtime;

    /**
     * 修改者ID;第一次创建时与CREATOR值相同，修改时与修改人值相同
     */
    private Long updaterid;

    /**
     * 修改时间;第一次创建时与CREATTIME值相同，修改时与修改时间相同
     */
    private Date updatetime;

    /**
     * 记录的有效性；1-有效；0-无效；
     */
    private Long isvalid;

    private BigDecimal isQuality;

    private BigDecimal isDelete;

    private BigDecimal dataCreateTime;

    private BigDecimal dataUpdateTime;

    private String htUniqueCode;

    /**
     * 净值来源：1-托管，2-私募报送，3-托管用印(私募转送)，4-默认初始净值
     */
    private BigDecimal navSource;
}