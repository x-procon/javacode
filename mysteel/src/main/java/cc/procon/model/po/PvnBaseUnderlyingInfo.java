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
public class PvnBaseUnderlyingInfo {
    /**
    * 主键ID
    */
    private Long id;

    /**
    * 标识，规则CODE-LAST-TYPE
    */
    private String uniCode;

    /**
    * 标的代码
    */
    private String underlyingCode;

    /**
    * 标的后缀
    */
    private String underlyingLast;

    /**
    * 标的简称
    */
    private String underlyingName;

    /**
    * 对应市场：1-股票市场，2-公募基金，3-债券市场，4-商品期货，5-金融期货，6-货币，7-私募基金，8-大宗商品，9-外汇，10-贵金属，-1-其他
    */
    private Long secType;

    /**
    * 创建时间,默认第一次创建的GETDATE()时间
    */
    private Date createtime;

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
}