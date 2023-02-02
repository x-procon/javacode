package cc.procon.model.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**

* ${describe}

*

* 

* @author procon

* @since 2023-01-31

*/
@Data
public class PvnFundStrategyRanknum {
    /**
    * 主键ID
    */
    private Long id;

    /**
    * 基金策略
    */
    private Long strategy;

    private Long substrategy;

    /**
    * 截至日期
    */
    private String endDate;

    /**
    * 参与排名基金数目（最近一个月）
    */
    private Long rankfunds1m;

    /**
    * 参与排名基金数目（最近三个月）
    */
    private Long rankfunds3m;

    /**
    * 参与排名基金数目（最近六个月）
    */
    private Long rankfunds6m;

    /**
    * 参与排名基金数目（最近一年）
    */
    private Long rankfunds1y;

    /**
    * 参与排名基金数目（最近两年）
    */
    private Long rankfunds2y;

    /**
    * 参与排名基金数目（最近三年）
    */
    private Long rankfunds3y;

    /**
    * 参与排名基金数目（今年以来）
    */
    private Long rankfundsYtd;

    /**
    * 一年评级基金数目
    */
    private Long ratingnum1y;

    /**
    * 两年评级基金数目
    */
    private Long ratingnum2y;

    /**
    * 三年评级基金数目
    */
    private Long ratingnum3y;

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

    /**
    * 参与排名基金数目（最近四年）
    */
    private Long rankfunds4y;

    /**
    * 参与排名基金数目（最近五年）
    */
    private Long rankfunds5y;

    /**
    * 参与排名基金数目（最近六年）
    */
    private Long rankfunds6y;

    /**
    * 参与排名基金数目（最近七年）
    */
    private Long rankfunds7y;

    /**
    * 参与排名基金数目（最近八年）
    */
    private Long rankfunds8y;

    /**
    * 参与排名基金数目（最近九年）
    */
    private Long rankfunds9y;

    /**
    * 参与排名基金数目（最近十年）
    */
    private Long rankfunds10y;

    /**
    * 四年评级基金数目
    */
    private Long ratingnum4y;

    /**
    * 五年评级基金数目
    */
    private Long ratingnum5y;

    /**
    * 十年评级基金数目
    */
    private Long ratingnum10y;

    private BigDecimal isQuality;

    private BigDecimal isDelete;

    private BigDecimal dataCreateTime;

    private BigDecimal dataUpdateTime;

    private String htUniqueCode;
}