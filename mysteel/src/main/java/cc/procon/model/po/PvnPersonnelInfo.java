package cc.procon.model.po;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * ${describe}
 *
 * @author procon
 * @since 2023-01-30
 */
@Data
public class PvnPersonnelInfo {
    /**
     * 人员ID
     */
    private String personnelId;

    /**
     * 人员类别，1-基金经理，2-研究员、3-联系人、-1-其他
     */
    private Long personnelType;

    /**
     * 职业背景：1-券商，2-公募，3-其他金融机构，4-媒体，5-海外，6-民间，7-期货，8-实业、9-学者、10-银行、11-信托、12-保险、13-私募、-1-其他
     */
    private Integer professionBackground;

    /**
     * 人员头像,93
     */
    private String avatar;

    /**
     * 是否为核心人物标志，1-是，0-否，-1-其他
     */
    private Long keyFigure;

    /**
     * 就职公司ID
     */
    private String companyId;

    /**
     * 当前职位
     */
    private String positions;

    /**
     * 从业开始年份
     */
    private String careerStartYear;

    /**
     * 从业年限，<量纲：年>,-1:从业年限不详
     */
    private Integer investmentExperience;

    /**
     * 性别，1-男，2-女，-1-其他
     */
    private Long sex;

    /**
     * 毕业院校
     */
    private String graduateschool;

    /**
     * 最高学历：1-小学、2-中学、3-大专、4-本科，5-硕士，6-博士，7-博士后，-1-其他
     */
    private Long education;

    /**
     * 人物简介
     */
    private String profile;

    /**
     * 人物次序
     */
    private Long orders;

    /**
     * 是否纳入团队信息
     */
    private Long ifinclude;

    /**
     * 人物是否在前台可见：1-可见，0-禁止显示
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
     * 是否有从业资格:1-是，2-否
     */
    private Integer isQualify;

    /**
     * 资格获取方式：1-考试，2-资格认定
     */
    private String getQualifyMethod;

    private Date createtime;

    private BigDecimal isQuality;

    private BigDecimal isDelete;

    private BigDecimal dataCreateTime;

    private BigDecimal dataUpdateTime;

    private String personnelName;

    private String major;

    private String topic;

    private String htUniqueCode;
}