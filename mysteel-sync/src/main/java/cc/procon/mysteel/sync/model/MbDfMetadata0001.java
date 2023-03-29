package cc.procon.mysteel.sync.model;

import lombok.Data;

import java.util.Date;

/**
 * ${describe}
 *
 * @author procon
 * @since 2023-03-29
 */
@Data
public class MbDfMetadata0001 {
    /**
     * 编号（GUID,主键
     */
    private String msId;

    /**
     * 框架ID
     */
    private Long frameId;

    /**
     * 上层ID
     */
    private Long pid;

    /**
     * 产品编码
     */
    private String proCode;

    /**
     * 层级编码
     */
    private String code;

    /**
     * 框架层级
     */
    private Integer frameLevel;

    /**
     * 框架中文全称
     */
    private String cnName;

    /**
     * 框架英文全称
     */
    private String enName;

    /**
     * 框架中文描述
     */
    private String cnDescription;

    /**
     * 框架英文描述
     */
    private String enDescription;

    /**
     * 框架路径
     */
    private String framePath;

    /**
     * 排序
     */
    private Integer priority;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 是否发布
     */
    private Integer isPublish;

    /**
     * 是否删除1：正常 -1：删除
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人ID
     */
    private String createUserId;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 更新人ID
     */
    private String updateUserId;

    /**
     * 更新人名称
     */
    private String updateUserName;

    /**
     * 是否为顶层框架
     */
    private Integer isTop;

    /**
     * 更新时间
     */
    private Date sourceUpdateTime;

    /**
     * 入库时间
     */
    private Date updateTime;

    /**
     * 框架路径ID
     */
    private String frameIdPath;
}