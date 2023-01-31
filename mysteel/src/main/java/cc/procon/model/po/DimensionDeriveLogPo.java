package cc.procon.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * 维表衍生日志(TDampDimensionDeriveLog)实体类
 *
 * @author chenan
 * @since 2022-07-12 09:35:26
 */
@Data
public class DimensionDeriveLogPo implements Serializable {
    private static final long serialVersionUID = 193603997296079270L;
    /**
    * 主键ID
    */
    private String id;
    /**
    * 衍生配置ID
    */
    private String deriveId;
    /**
    * 状态 1 成功 0 失败
    */
    private Integer status;
    /**
    * 流转数据总量
    */
    private Integer dataNums;
    /**
    * 成功次数
    */
    private Integer successTimes;
    /**
    * 失败次数
    */
    private Integer failTimes;
    /**
    * 失败说明，汇总去重所有的失败原因
    */
    private String failReasonContent;
    /**
    * 流转开始时间
    */
    private Long startTime;
    /**
    * 流转结束时间
    */
    private Long endTime;
    /**
    * 是否启用，1：是，0：否
    */
    private Integer isEnable;
    /**
    * 是否删除，1：是，0：否
    */
    private Integer isDelete;
    /**
    * 创建时间
    */
    private Long createTime;
    /**
    * 修改时间
    */
    private Long updateTime;
    /**
    * 创建人ID
    */
    private Long createUserId;
    /**
    * 创建人名称
    */
    private String createUserName;
    /**
    * 修改人ID
    */
    private Long updateUserId;
    /**
    * 修改人名称
    */
    private String updateUserName;

}