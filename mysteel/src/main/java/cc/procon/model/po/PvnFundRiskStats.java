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
public class PvnFundRiskStats {
    private Long id;

    private String fundId;

    private String endDate;

    private BigDecimal stddev1y;

    private BigDecimal stddev2y;

    private BigDecimal stddev3y;

    private BigDecimal stddev4y;

    private BigDecimal stddev5y;

    private BigDecimal stddev10y;

    private BigDecimal stddevIncep;

    private BigDecimal downsidedev1y;

    private BigDecimal downsidedev2y;

    private BigDecimal downsidedev3y;

    private BigDecimal downsidedev4y;

    private BigDecimal downsidedev5y;

    private BigDecimal downsidedev10y;

    private BigDecimal downsidedevIncep;

    private BigDecimal alpha1y;

    private BigDecimal alpha2y;

    private BigDecimal alpha3y;

    private BigDecimal alpha4y;

    private BigDecimal alpha5y;

    private BigDecimal alpha10y;

    private BigDecimal alphaIncep;

    private BigDecimal beta1y;

    private BigDecimal beta2y;

    private BigDecimal beta3y;

    private BigDecimal beta4y;

    private BigDecimal beta5y;

    private BigDecimal beta10y;

    private BigDecimal betaIncep;

    private BigDecimal r21y;

    private BigDecimal r22y;

    private BigDecimal r23y;

    private BigDecimal r24y;

    private BigDecimal r25y;

    private BigDecimal r210y;

    private BigDecimal r2Incep;

    private BigDecimal skewness1y;

    private BigDecimal skewness2y;

    private BigDecimal skewness3y;

    private BigDecimal skewness4y;

    private BigDecimal skewness5y;

    private BigDecimal skewness10y;

    private BigDecimal skewnessIncep;

    private BigDecimal kurtosis1y;

    private BigDecimal kurtosis2y;

    private BigDecimal kurtosis3y;

    private BigDecimal kurtosis4y;

    private BigDecimal kurtosis5y;

    private BigDecimal kurtosis10y;

    private BigDecimal kurtosisIncep;

    private BigDecimal worstmonth1y;

    private BigDecimal worstmonth2y;

    private BigDecimal worstmonth3y;

    private BigDecimal worstmonth4y;

    private BigDecimal worstmonth5y;

    private BigDecimal worstmonth10y;

    private BigDecimal worstmonthIncep;

    private BigDecimal downmonthPercent1y;

    private BigDecimal downmonthPercent2y;

    private BigDecimal downmonthPercent3y;

    private BigDecimal downmonthPercent4y;

    private BigDecimal downmonthPercent5y;

    private BigDecimal downmonthPercent10y;

    private BigDecimal downmonthPercentIncep;

    private BigDecimal battingaverage1y;

    private BigDecimal battingaverage2y;

    private BigDecimal battingaverage3y;

    private BigDecimal battingaverage4y;

    private BigDecimal battingaverage5y;

    private BigDecimal battingaverage10y;

    private BigDecimal battingaverageIncep;

    private BigDecimal gainlossRatio1y;

    private BigDecimal gainlossRatio2y;

    private BigDecimal gainlossRatio3y;

    private BigDecimal gainlossRatio4y;

    private BigDecimal gainlossRatio5y;

    private BigDecimal gainlossRatio10y;

    private BigDecimal gainlossRatioIncep;

    private Long ldMonths1y;

    private Long ldMonths2y;

    private Long ldMonths3y;

    private Long ldMonths4y;

    private Long ldMonths5y;

    private Long ldMonths10y;

    private Long ldMonthsIncep;

    private BigDecimal ytdMaxdrawdown;

    private Long mMaxdrawdown;

    private BigDecimal maxdrawdown1y;

    private Long maxdrawdownMonths1y;

    private String maxdrawdownPeakdate1y;

    private String mdValleydate1y;

    private String mdDate1y;

    private Long mdMonths1y;

    private BigDecimal maxdrawdown2y;

    private Long maxdrawdownMonths2y;

    private String maxdrawdownPeakdate2y;

    private String mdValleydate2y;

    private String mdDate2y;

    private Long mdMonths2y;

    private BigDecimal maxdrawdown3y;

    private Long maxdrawdownMonths3y;

    private String maxdrawdownPeakdate3y;

    private String mdValleydate3y;

    private String mdDate3y;

    private Long mdMonths3y;

    private BigDecimal maxdrawdownIncep;

    private Long maxdrawdownMonthsIncep;

    private String maxdrawdownPeakdateIncep;

    private String mdValleydateIncep;

    private String mdDateIncep;

    private Long mdMonthsIncep;

    private BigDecimal maxdrawdown4y;

    private Long maxdrawdownMonths4y;

    private String maxdrawdownPeakdate4y;

    private String mdValleydate4y;

    private String mdDate4y;

    private Long mdMonths4y;

    private BigDecimal maxdrawdown5y;

    private Long maxdrawdownMonths5y;

    private String maxdrawdownPeakdate5y;

    private String mdValleydate5y;

    private String mdDate5y;

    private Long mdMonths5y;

    private BigDecimal maxdrawdown10y;

    private Long maxdrawdownMonths10y;

    private String maxdrawdownPeakdate10y;

    private String mdValleydate10y;

    private String mdDate10y;

    private Long mdMonths10y;

    private Integer isvalid;

    private Date createtime;

    private Long creatorid;

    private Date updatetime;

    private Long updaterid;

    private BigDecimal winrateYtd;

    private BigDecimal winrate6m;

    private BigDecimal winrate1y;

    private BigDecimal winrate2y;

    private BigDecimal winrate3y;

    private BigDecimal winrate4y;

    private BigDecimal winrate5y;

    private BigDecimal winrate10y;

    private BigDecimal winrateIncep;

    private BigDecimal isQuality;

    private BigDecimal isDelete;

    private BigDecimal dataCreateTime;

    private BigDecimal dataUpdateTime;

    private String htUniqueCode;

    /**
    * 今年以来阿尔法
    */
    private BigDecimal alphaYtd;

    /**
    * 最近半年的贝塔
    */
    private BigDecimal beta6m;

    /**
    * 今年以来的贝塔
    */
    private BigDecimal betaYtd;

    /**
    * 今年以来下行风险
    */
    private BigDecimal downsidedevYtd;

    /**
    * 今年以来峰度
    */
    private BigDecimal kurtosisYtd;

    /**
    * 最近十年的最长连续下跌月份数
    */
    private BigDecimal longestdownMonths10y;

    /**
    * 最近一年的最长连续下跌月份数
    */
    private BigDecimal longestdownMonths1y;

    /**
    * 最近两年的最长连续下跌月份数
    */
    private BigDecimal longestdownMonths2y;

    /**
    * 最近三年的最长连续下跌月份数
    */
    private BigDecimal longestdownMonths3y;

    /**
    * 最近四年的最长连续下跌月份数
    */
    private BigDecimal longestdownMonths4y;

    /**
    * 最近五年的最长连续下跌月份数
    */
    private BigDecimal longestdownMonths5y;

    /**
    * 成立以来的最长连续下跌月份数
    */
    private BigDecimal longestdownMonthsIncep;

    /**
    * 今年以来的最长连续下跌月份数
    */
    private BigDecimal longestdownMonthsYtd;

    /**
    * 最近一月的最大回撤
    */
    private BigDecimal maxdrawdown1m;

    /**
    * 最近三月最大回撤
    */
    private BigDecimal maxdrawdown3m;

    /**
    * 最近半年最大回撤
    */
    private BigDecimal maxdrawdown6m;

    /**
    * 最近半年的最大回撤区间月份数
    */
    private BigDecimal maxdrawdownMonths6m;

    /**
    * 最近一年的最大回撤区间月份数
    */
    private BigDecimal maxdrawdownMonthsYtd;

    /**
    * 最近六月的最大回撤的峰值值起始日期
    */
    private Date maxdrawdownPeakdate6m;

    /**
    * 最近一年的最大回撤的峰值值起始日期
    */
    private Date maxdrawdownPeakdateYtd;

    /**
    * 最近十年的最大回撤修复日期
    */
    private String maxdrawdownRecoverydate10y;

    /**
    * 最近一年的最大回撤修复日期
    */
    private String maxdrawdownRecoverydate1y;

    /**
    * 最近两年的最大回撤修复日期
    */
    private String maxdrawdownRecoverydate2y;

    /**
    * 最近三年的最大回撤修复日期
    */
    private String maxdrawdownRecoverydate3y;

    /**
    * 最近四年的最大回撤修复日期
    */
    private String maxdrawdownRecoverydate4y;

    /**
    * 最近五年的最大回撤修复日期
    */
    private String maxdrawdownRecoverydate5y;

    /**
    * 最近半年的最大回撤修复日期
    */
    private String maxdrawdownRecoverydate6m;

    /**
    * 成立以来的最大回撤修复日期
    */
    private String maxdrawdownRecoverydateIncep;

    /**
    * 今年以来的最大回撤修复日期
    */
    private String maxdrawdownRecoverydateYtd;

    /**
    * 最近十年的最大回撤修复区间月份数
    */
    private BigDecimal maxdrawdownRecoverymonths10y;

    /**
    * 最近一年的最大回撤修复区间月份数
    */
    private BigDecimal maxdrawdownRecoverymonths1y;

    /**
    * 最近两年的最大回撤修复区间月份数
    */
    private BigDecimal maxdrawdownRecoverymonths2y;

    /**
    * 最近三年的最大回撤修复区间月份数
    */
    private BigDecimal maxdrawdownRecoverymonths3y;

    /**
    * 最近四年的最大回撤修复区间月份数
    */
    private BigDecimal maxdrawdownRecoverymonths4y;

    /**
    * 最近五年的最大回撤修复区间月份数
    */
    private BigDecimal maxdrawdownRecoverymonths5y;

    /**
    * 最近半年的最大回撤修复区间月份数
    */
    private BigDecimal maxdrawdownRecoverymonths6m;

    /**
    * 今年以来的最大回撤修复区间月份数
    */
    private BigDecimal maxdrawdownRecoverymonthsYtd;

    /**
    * 最近十年的最大回撤的谷值截止日期
    */
    private String maxdrawdownValleydate10y;

    /**
    * 最近一年的最大回撤的谷值截止日期
    */
    private String maxdrawdownValleydate1y;

    /**
    * 最近两年的最大回撤的谷值截止日期
    */
    private String maxdrawdownValleydate2y;

    /**
    * 最近三年的最大回撤的谷值截止日期
    */
    private String maxdrawdownValleydate3y;

    /**
    * 最近四年的最大回撤的谷值截止日期
    */
    private String maxdrawdownValleydate4y;

    /**
    * 最近五年的最大回撤的谷值截止日期
    */
    private String maxdrawdownValleydate5y;

    /**
    * 最近六月的最大回撤的谷值截止日期
    */
    private Date maxdrawdownValleydate6m;

    /**
    * 成立以来的最大回撤的谷值截止日期
    */
    private String maxdrawdownValleydateIncep;

    /**
    * 最近一年的最大回撤的谷值截止日期
    */
    private Date maxdrawdownValleydateYtd;

    /**
    * 今年以来最大回撤
    */
    private BigDecimal maxdrawdownYtd;

    /**
    * 今年以来偏度
    */
    private BigDecimal skewnessYtd;

    /**
    * 最近一个月的年化波动率
    */
    private BigDecimal stddev1m;

    /**
    * 最近三个月的年化波动率
    */
    private BigDecimal stddev3m;

    /**
    * 最近半年的年化波动率
    */
    private BigDecimal stddev6m;

    /**
    * 今年以来的年化波动率
    */
    private BigDecimal stddevYtd;

    /**
    * 今年以来的单月最大下跌
    */
    private BigDecimal worstmonthYtd;

    /**
    * 成立以来的最大回撤修复区间月份数
    */
    private BigDecimal maxdrawdownRecoveryIncep;
}