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
public class PvnCompanyInfo {
    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 上级公司ID
     */
    private String pCompanyId;

    /**
     * 公司中文全称
     */
    private String companyName;

    /**
     * 基金管理人全称（英文）
     */
    private String companyEnglishName;

    /**
     * 公司类型
     */
    private Long companyType;

    /**
     * 公司成立日期
     */
    private String organizationNumber;

    /**
     * 公司成立日期
     */
    private Date establishDate;

    /**
     * 公司注册国家：1-中国大陆、2-香港、3-新加坡、4-开曼群岛、5-台湾、6-英属维尔京群岛BVI、-1-其他
     */
    private Long domicileId;

    /**
     * 公司注册地址
     */
    private String companyAddress;

    /**
     * 办公地址
     */
    private String companyAddress2;

    /**
     * 城市
     */
    private String city;

    /**
     * 省
     */
    private String province;

    /**
     * 国家
     */
    private String country;

    /**
     * 注册城市
     */
    private String regCity;

    /**
     * 注册省
     */
    private String regProvince;

    /**
     * 注册省
     */
    private String regCountry;

    /**
     *
     */
    private String contactPhone;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     *
     */
    private String fax;

    /**
     *
     */
    private String email;

    /**
     * 公司网址
     */
    private String website;

    /**
     * 公司注册资本，<量纲：万元>
     */
    private BigDecimal registeredCapital;

    /**
     * 公司简介
     */
    private String companyProfile;

    /**
     * 是否有海外基金，0-否，1-是，-1-其他
     */
    private Long offshoreFund;

    /**
     * 投资理念
     */
    private String philosopy;

    /**
     * 公司状态：1-运行；2-注销
     */
    private Long companyStatus;

    /**
     * 公司注册资本货币单位：1-人民币，2-港币，3-美元，-1-其他
     */
    private Long baseCurrencyCrc;

    /**
     * 备案编码
     */
    private String registerNumber;

    /**
     * 备案状态：0-未备案,1-备案注销,2-备案存续
     */
    private Integer registerStatus;

    /**
     * 备案日期
     */
    private Date registerDate;

    /**
     * 是否会员：1-是，0-否
     */
    private Integer isMember;

    /**
     * 入会时间
     */
    private Date joinDate;

    /**
     * 会员类型：1-普通会员、2-联席会员、3-观察会员、4-特别会员
     */
    private Integer memberType;

    /**
     * 管理基金主要类别（与中基协同步）
     */
    private String fundCategoryOri;

    /**
     * 企业性质:1 中外合作企业  2中外合资企业 3内资企业  4境外机构 5外商独资企业 6政府机构
     */
    private Integer natureBusinessType;

    /**
     * 注册资本实缴比例
     */
    private BigDecimal capitalPaidRate;

    /**
     *
     */
    private String registerNumberAddress;

    /**
     * 公司LOGO
     */
    private String logo;

    /**
     * 公司是否在前台可见
     */
    private Long isvisible;

    /**
     * 记录的有效性；1-有效；0-无效；
     */
    private Long isvalid;

    /**
     * 修改时间;第一次创建时与CREATTIME值相同，修改时与修改时间相同
     */
    private Date updatetime;

    /**
     * 实缴资本(万元)(人民币)
     */
    private BigDecimal paidCapital;

    /**
     * “私募创业投资”或者“私募其他投资”
     */
    private Integer companyAssetSize;

    /**
     * 法人代表
     */
    private String legalRepresentative;

    /**
     * 法人代表履历
     */
    private String representativeExperience;

    /**
     * 是否认证
     */
    private String isQualify;

    /**
     * 法人从业资格获得方式
     */
    private String getQualifyMethod;

    /**
     * 员工人数
     */
    private Long employeeCnts;

    /**
     * 提示信息
     */
    private String specialTips;

    /**
     * 协会链接
     */
    private String amacLink;

    /**
     * 管理规模(确数)
     */
    private BigDecimal fundscale;

    private Date createtime;

    /**
     * 信用代码
     */
    private String creditCode;

    /**
     * 是否有投顾资质：1-是；0-否
     */
    private Long hasConsultingQualification;

    private String legalOpinionStatus;

    private Date fundscaleDate;

    private Integer cancelType;

    private Date cancelDate;

    private BigDecimal isQuality;

    private BigDecimal isDelete;

    private BigDecimal dataCreateTime;

    private BigDecimal dataUpdateTime;

    private String businessType;

    private String integrityInfo;

    private String companyShortName;

    private String htUniqueCode;
}