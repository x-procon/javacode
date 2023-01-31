package cc.procon.model.po;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**

* ${describe}

*

* 

* @author procon

* @since 2023-01-29

*/
@Data
public class PvnFundIndicatorWeekly {
    /**
    * ID
    */
    private Long id;

    /**
    * 基金ID
    */
    private String fundId;

    /**
    * 截止月份
    */
    private String endDate;

    /**
    * 业绩持续性最近一月
    */
    private BigDecimal perCon1m;

    /**
    * 业绩持续性最近半年
    */
    private BigDecimal perCon6m;

    /**
    * 业绩持续性今年以来
    */
    private BigDecimal perConYtd;

    /**
    * 业绩持续性最近一年
    */
    private BigDecimal perCon1y;

    /**
    * 业绩持续性最近两年
    */
    private BigDecimal perCon2y;

    /**
    * 业绩持续性最近三年
    */
    private BigDecimal perCon3y;

    /**
    * 业绩持续性最近四年
    */
    private BigDecimal perCon4y;

    /**
    * 业绩持续性最近五年
    */
    private BigDecimal perCon5y;

    /**
    * 业绩持续性最近10年
    */
    private BigDecimal perCon10y;

    /**
    * 业绩持续性成立以来
    */
    private BigDecimal perConIncep;

    /**
    * 信息比率最近半年
    */
    private BigDecimal infoRatio6m;

    /**
    * 信息比率今年以来
    */
    private BigDecimal infoRatioYtd;

    /**
    * 信息比率最近一年
    */
    private BigDecimal infoRatio1y;

    /**
    * 信息比率最近两年
    */
    private BigDecimal infoRatio2y;

    /**
    * 信息比率最近三年
    */
    private BigDecimal infoRatio3y;

    /**
    * 信息比率最近四年
    */
    private BigDecimal infoRatio4y;

    /**
    * 信息比率最近五年
    */
    private BigDecimal infoRatio5y;

    /**
    * 信息比率最近十年
    */
    private BigDecimal infoRatio10y;

    /**
    * 信息比率最近成立以来
    */
    private BigDecimal infoRatioIncep;

    /**
    * 最近半年M2
    */
    private BigDecimal m26m;

    /**
    * 今年以来M2
    */
    private BigDecimal m2Ytd;

    /**
    * 最近一年M2
    */
    private BigDecimal m21y;

    /**
    * 最近两年M2
    */
    private BigDecimal m22y;

    /**
    * 最近三年M2
    */
    private BigDecimal m23y;

    /**
    * 最近四年M2
    */
    private BigDecimal m24y;

    /**
    * 最近五年M2
    */
    private BigDecimal m25y;

    /**
    * 最近十年M2
    */
    private BigDecimal m210y;

    /**
    * 成立以来M2
    */
    private BigDecimal m2Incep;

    /**
    * 最近半年TRACKING_ERROR_
    */
    private BigDecimal trackingError6m;

    /**
    * 今年以来TRACKING_ERROR_
    */
    private BigDecimal trackingErrorYtd;

    /**
    * 最近一年TRACKING ERROR
    */
    private BigDecimal trackingError1y;

    /**
    * 最近两年TRACKING ERROR
    */
    private BigDecimal trackingError2y;

    /**
    * 最近三年TRACKING ERROR
    */
    private BigDecimal trackingError3y;

    /**
    * 最近四年TRACKING ERROR
    */
    private BigDecimal trackingError4y;

    /**
    * 最近五年TRACKING ERROR
    */
    private BigDecimal trackingError5y;

    /**
    * 最近十年TRACKING ERROR
    */
    private BigDecimal trackingError10y;

    /**
    * 成立以来TRACKING ERROR
    */
    private BigDecimal trackingErrorIncep;

    /**
    * 最近半年VAR
    */
    private BigDecimal var6m;

    /**
    * 今年以来的VAR
    */
    private BigDecimal varYtd;

    /**
    * 最近一年VAR
    */
    private BigDecimal var1y;

    /**
    * 最近两年VAR
    */
    private BigDecimal var2y;

    /**
    * 最近三年VAR
    */
    private BigDecimal var3y;

    /**
    * 最近四年VAR
    */
    private BigDecimal var4y;

    /**
    * 最近五年VAR
    */
    private BigDecimal var5y;

    /**
    * 最近十年VAR
    */
    private BigDecimal var10y;

    /**
    * 成立以来VAR
    */
    private BigDecimal varIncep;

    /**
    * 最近半年的CVAR
    */
    private BigDecimal cvar6m;

    /**
    * 今年以来的CVAR
    */
    private BigDecimal cvarYtd;

    /**
    * 最近一年CVAR
    */
    private BigDecimal cvar1y;

    /**
    * 最近两年CVAR
    */
    private BigDecimal cvar2y;

    /**
    * 最近三年CVAR
    */
    private BigDecimal cvar3y;

    /**
    * 最近四年CVAR
    */
    private BigDecimal cvar4y;

    /**
    * 最近五年CVAR
    */
    private BigDecimal cvar5y;

    /**
    * 最近十年CVAR
    */
    private BigDecimal cvar10y;

    /**
    * 成立以来CVAR
    */
    private BigDecimal cvarIncep;

    /**
    * 最近半年SMDDVAR
    */
    private BigDecimal smddvar6m;

    /**
    * 今年以来SMDDVAR
    */
    private BigDecimal smddvarYtd;

    /**
    * 最近一年SMDDVAR
    */
    private BigDecimal smddvar1y;

    /**
    * 最近两年SMDDVAR
    */
    private BigDecimal smddvar2y;

    /**
    * 最近三年SMDDVAR
    */
    private BigDecimal smddvar3y;

    /**
    * 最近四年SMDDVAR
    */
    private BigDecimal smddvar4y;

    /**
    * 最近五年SMDDVAR
    */
    private BigDecimal smddvar5y;

    /**
    * 最近十年SMDDVAR
    */
    private BigDecimal smddvar10y;

    /**
    * 成立以来SMDDVAR
    */
    private BigDecimal smddvarIncep;

    /**
    * 最近半年SMDDCVAR
    */
    private BigDecimal smddcvar6m;

    /**
    * 今年以来SMDDCVAR
    */
    private BigDecimal smddcvarYtd;

    /**
    * 最近一年SMDDCVAR
    */
    private BigDecimal smddcvar1y;

    /**
    * 最近两年SMDDCVAR
    */
    private BigDecimal smddcvar2y;

    /**
    * 最近三年SMDDCVAR
    */
    private BigDecimal smddcvar3y;

    /**
    * 最近四年SMDDCVAR
    */
    private BigDecimal smddcvar4y;

    /**
    * 最近五年SMDDCVAR
    */
    private BigDecimal smddcvar5y;

    /**
    * 最近十年SMDDCVAR
    */
    private BigDecimal smddcvar10y;

    /**
    * 成立以来SMDDCVAR
    */
    private BigDecimal smddcvarIncep;

    /**
    * 最近半年SMDD_LPM1
    */
    private BigDecimal smddLpm16m;

    /**
    * 今年以来SMDD_LPM1
    */
    private BigDecimal smddLpm1Ytd;

    /**
    * 最近一年SMPPLPM1
    */
    private BigDecimal smddLpm11y;

    /**
    * 最近两年SMPPLPM1
    */
    private BigDecimal smddLpm12y;

    /**
    * 最近三年SMPPLPM1
    */
    private BigDecimal smddLpm13y;

    /**
    * 最近四年SMPPLPM1
    */
    private BigDecimal smddLpm14y;

    /**
    * 最近五年SMPPLPM1
    */
    private BigDecimal smddLpm15y;

    /**
    * 最近十年SMPPLPM1
    */
    private BigDecimal smddLpm110y;

    /**
    * 成立以来SMPPLPM1
    */
    private BigDecimal smddLpm1Incep;

    /**
    * 最近半年SMDD_LPM2
    */
    private BigDecimal smddLpm26m;

    /**
    * 今年以来SMDD_LPM2
    */
    private BigDecimal smddLpm2Ytd;

    /**
    * 最近一年SMPPLPM2
    */
    private BigDecimal smddLpm21y;

    /**
    * 最近两年SMPPLPM2
    */
    private BigDecimal smddLpm22y;

    /**
    * 最近三年SMPPLPM2
    */
    private BigDecimal smddLpm23y;

    /**
    * 最近四年SMPPLPM2
    */
    private BigDecimal smddLpm24y;

    /**
    * 最近五年SMPPLPM2
    */
    private BigDecimal smddLpm25y;

    /**
    * 最近十年SMPPLPM2
    */
    private BigDecimal smddLpm210y;

    /**
    * 成立以来SMPPLPM2
    */
    private BigDecimal smddLpm2Incep;

    /**
    * 最近半年下行偏差
    */
    private BigDecimal smddDownsideDev6m;

    /**
    * 今年以来下行偏差
    */
    private BigDecimal smddDownsideDevYtd;

    /**
    * 最近一年下行偏差
    */
    private BigDecimal smddDownsideDev1y;

    /**
    * 最近两年下行偏差
    */
    private BigDecimal smddDownsideDev2y;

    /**
    * 最近三年下行偏差
    */
    private BigDecimal smddDownsideDev3y;

    /**
    * 最近四年下行偏差
    */
    private BigDecimal smddDownsideDev4y;

    /**
    * 最近五年下行偏差
    */
    private BigDecimal smddDownsideDev5y;

    /**
    * 最近十年下行偏差
    */
    private BigDecimal smddDownsideDev10y;

    /**
    * 成立以来下行偏差
    */
    private BigDecimal smddDownsideDevIncep;

    /**
    * 记录的有效性；1-有效；0-无效；
    */
    private Long isvalid;

    /**
    * 修改时间;第一次创建时与CREATTIME值相同，修改时与修改时间相同
    */
    private Date updatetime;

    private BigDecimal isQuality;

    private BigDecimal isDelete;

    private BigDecimal dataCreateTime;

    private BigDecimal dataUpdateTime;

    private String htUniqueCode;

    /**
    * 创建时间
    */
    private Date createtime;

    /**
    * 信息比率最近三月
    */
    private BigDecimal infoRatio3m;

    /**
    * 最近三月m2
    */
    private BigDecimal m23m;
}