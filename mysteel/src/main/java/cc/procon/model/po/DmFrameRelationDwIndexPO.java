package cc.procon.model.po;

import lombok.Data;

/**
 * T_DAMP_DM_RL_DW_INDEX
 *
 * @author fanzhibiao
 */
@Data
public class DmFrameRelationDwIndexPO {
    /**
     * dm层指标框架id
     */
    private String frameId;

    /**
     * dw层指标id
     */
    private String indexId;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 是否启用，0：否，1：是
     */
    private Integer isEnable;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 创建人id
     */
    private Long createUserId;
    /**
     * 创建人名称
     */
    private String createUserName;
    /**
     * 更新人id
     */
    private Long updateUserId;
    /**
     * 更新人名称
     */
    private String updateUserName;

}