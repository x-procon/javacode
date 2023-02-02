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
public class PvnFundInfo {
    private Long id;

    /**
     * 父级产品ID
     */
    private String pFundId;

    /**
     * 基金ID，'HF'开头(后加36进制编码格式,不足8位长度左补零） 例：HF00000001
     */
    private String fundId;

    /**
     * 基金中文全称
     */
    private String fundName;

    /**
     * 基金形式：1-公司型，2-合伙型，3-契约型，-1-其他
     */
    private Long fundStructure;

    /**
     * 1-信托计划，2-有限合伙，3-券商资管，4-公募专户，5-单账户，6-证券投资基金，7-海外基金，8-期货资管，9-保险资管、10-创业投资基金、11-股权投资基金、12-银行理财、13-类固收信托、-1其他投资基金
     */
    private Integer fundType;

    /**
     * 募集方式：1-私募，2-公募
     */
    private Integer raiseType;

    /**
     * 券商资管产品特点
     */
    private String fundCharacteristic;

    /**
     * 基础货币,1-人民币，2-港币，3-美元，4-份，-1-其他
     */
    private Long baseCurrency;

    /**
     *
     */
    private Date inceptionDate;

    /**
     * 注册国家,1-中国大陆、2-香港、3-新加坡、4-开曼群岛、5-台湾、6-英属维尔京群岛BVI、-1-其他
     */
    private Long domicile;

    /**
     * 指数ID，以'IN'开头(后加36进制编码格式,不足8位长度左补零） 例：IN00000001
     */
    private String primaryBenchmarkId;

    /**
     * 封闭期，单位：月，-1：不确定，0：无封闭期
     */
    private Long lockupPeriod;

    /**
     * 产品存续期，单位：月。-1，不确定，0，无固定期限，999999永续
     */
    private Long duration;

    /**
     * 基金投资范围
     */
    private String investmentScope;

    /**
     * 投资限制
     */
    private String investmentRestriction;

    /**
     * 投资理念
     */
    private String fundInvestmentPhilosophy;

    /**
     * 投资策略
     */
    private String fundStrategyDescription;

    /**
     * 投资顾问ID
     */
    private String advisorId;

    /**
     * 证券经纪人ID
     */
    private String brokerId;

    /**
     * 期货经纪人ID
     */
    private String brokerFutureId;

    /**
     * 外包机构ID
     */
    private String liquidationAgencyId;

    /**
     * 基金管理公司ID
     */
    private String trustId;

    /**
     *
     */
    private String investmentConsultantId;

    /**
     * 行政管理人ID
     */
    private String administratorId;

    /**
     * 法律顾问ID
     */
    private String legalCounselId;

    /**
     * 审计机构
     */
    private String auditorId;

    /**
     * 净值披露频率
     */
    private String navFrequency;

    /**
     * 产品业绩披露标识：1-AAA，2-AA，3-A，4-A-
     */
    private Integer performanceDisclosureMark;

    /**
     * 记录的有效性；1-有效；0-无效；
     */
    private Long isvalid;

    /**
     *
     */
    private String registerNumber;

    /**
     * 备案日期
     */
    private Date registerDate;

    /**
     * 基金在前台是否可见
     */
    private Long isvisible;

    /**
     * 是否分级：1-分级，0-不分级;
     */
    private Integer istiered;

    /**
     * 修改时间;第一次创建时与CREATTIME值相同，修改时与修改时间相同
     */
    private Date updatetime;

    /**
     * 是否参与排名，1-参与排名 0-不参与排名
     */
    private Long isRanking;

    /**
     * 是否参与评级，1-参与评级 0-不参与评级
     */
    private Long isRating;

    private Integer navSourceType;

    private Date createtime;

    private Integer isFeeBefore;

    private Integer isDeductReward;

    private String trustRegisterNumber;

    private BigDecimal isQuality;

    private BigDecimal isDelete;

    private BigDecimal dataCreateTime;

    private BigDecimal dataUpdateTime;

    /**
     * 发行人id
     */
    private String issuerId;

    private String fundShortName;

    private String specialTips;

    private String amacUrl;

    private String custodianId;

    private String openDay;

    private String htUniqueCode;

    /**
     * 基金资产配置比例
     */
    private String fundPortfolio;

    /**
     * 单位面值
     */
    private BigDecimal initialUnitValue;

    /**
     * 投资目标
     */
    private String investmentObjective;

    /**
     * 封闭期单位：1-天，2-月
     */
    private BigDecimal lockupPeriodUnit;

    /**
     * 锁定期，单位：月-1-不确定，0-无锁定期
     */
    private BigDecimal lockPeriod;

    /**
     * 锁定期单位：1-天，2-月
     */
    private BigDecimal lockPeriodUnit;

    /**
     * 管理类型：1-顾问管理，2-受托管理，3-自我管理
     */
    private BigDecimal managerType;

    /**
     * 产品业绩披露方式:1-净值
     */
    private BigDecimal performanceDisclosureType;

    /**
     * 赎回日
     */
    private String redemptionDay;

    /**
     * 业绩基准指数及其说明
     */
    private String secondaryBenchmark;
}