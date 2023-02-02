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
public class PvnPersonnelCompanyMapping {
    private Long id;

    /**
    * 人物ID
    */
    private String personnelId;

    /**
    * 任职公司ID
    */
    private String companyId;

    /**
    * 公司次序
    */
    private Long companyOrder;

    /**
    * 人物次序
    */
    private Long personnelOrder;

    /**
    * 联系地址
    */
    private String address;

    /**
    * 是否为核心人物标志，1-是，0-否，-1-其他
    */
    private Long isKeyfigure;

    /**
    * 是否纳入团队信息
    */
    private Long isInclude;

    /**
    * 人物是否在前台可见：1-可见，0-禁止显示
    */
    private Long isVisible;

    /**
    * 人物是否离职：1-是，0-否
    */
    private Long isLeave;

    /**
    * 默认任职公司：1-是，0-否
    */
    private Long isDefault;

    /**
    * 是否高管：1-是，0-否
    */
    private Integer isSenior;

    /**
    * 是否法人：1-是，0-否
    */
    private Integer isRepresent;

    /**
    * 任职开始日期
    */
    private Date startDate;

    /**
    * 任职结束日期
    */
    private Date endDate;

    /**
    * 创建时间
    */
    private Date createtime;

    /**
    * 更新时间
    */
    private Date updatetime;

    /**
    * 是否有效：1-是，0-否
    */
    private Long isvalid;

    private BigDecimal isQuality;

    private BigDecimal isDelete;

    private BigDecimal dataCreateTime;

    private BigDecimal dataUpdateTime;

    private String htUniqueCode;
}