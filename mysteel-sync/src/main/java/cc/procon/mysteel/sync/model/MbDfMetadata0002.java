package cc.procon.mysteel.sync.model;

import lombok.Data;

import java.util.Date;

/**

* ${describe}

*

* 

* @author procon

* @since 2023-03-29

*/
@Data
public class MbDfMetadata0002 {
    /**
    * 编号（GUID,主键）
    */
    private String msId;

    /**
    * 框架ID
    */
    private Long frameId;

    /**
    * 新指标编码
    */
    private String indexCode;

    /**
    * 产品编码
    */
    private String proCode;

    /**
    * 排序
    */
    private Integer priority;

    /**
    * 是否显示
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
    * create_user_id
    */
    private String createUserId;

    /**
    * 创建人名称
    */
    private String createUserName;

    /**
    * 更新时间
    */
    private Date sourceUpdateTime;

    /**
    * 更新人ID
    */
    private String updateUserId;

    /**
    * 更新人名称
    */
    private String updateUserName;

    /**
    * 进入数仓时间
    */
    private Date updateTime;

    private String indexName;
    private String indexShortName;
}