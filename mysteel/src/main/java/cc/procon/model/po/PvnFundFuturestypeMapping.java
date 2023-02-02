package cc.procon.model.po;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**

* ${describe}

*

* 

* @author procon

* @since 2023-01-31

*/
@Data
public class PvnFundFuturestypeMapping {
    /**
    * ID
    */
    private Long id;

    /**
    * 基金ID
    */
    private String fundId;

    /**
    * 投资品种:1-商品期货、2-金融期货、3-股票、4-债券型、5-指数型、6-期权型、7-基金型、8-新三板、-1-其他;
    */
    private Integer futuresType;

    /**
    * 修改时间;第一次创建时与CREATTIME值相同，修改时与修改时间相同
    */
    private Date updatetime;

    /**
    * 记录的有效性；1-有效；0-无效；
    */
    private Long isvalid;

    private Date createtime;

    private BigDecimal isQuality;

    private BigDecimal isDelete;

    private BigDecimal dataCreateTime;

    private BigDecimal dataUpdateTime;

    private String htUniqueCode;
}