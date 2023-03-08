package cc.procon.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TDampOdsDimensionInfo)实体类
 *
 * @author chenan
 * @since 2022-04-08 15:23:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DimensionInfoPO implements Serializable {
    private static final long serialVersionUID = 166456843781039290L;
    /**
    * 主键
    */
    private String id;
    /**
     * 维表名称
     */
    private String cnName;
    /**
    * 维表名称
    */
    private String tableName;
    /**
    * 维表唯一code
    */
    private String tableCode;
    /**
    * 落地库类型（1:oracle,2:Hbase,-1:未知）
    */
    private Integer sourceType;
    /**
    * 是否对外提供
    */
    private Integer isForeign;
    /**
    * 框架id
    */
    private String frameId;
    /**
    * 维表描述
    */
    private String remarks;
    /**
    * 是否删除，0：否，1：是
    */
    private Integer isDelete;
    /**
    * 是否启用，1：启用，0：未启用
    */
    private Integer isEnable;
    /**
    * 表字段信息(JSON)
    */
    private String tableFileds;
    /**
    * 记录第三方数据源(1.钢联2xxxx
    */
    private Integer dataSource;
    /**
    * 数据来源原表名称用逗号分隔
    */
    private String sourceTableName;
    /**
     * 数据来源-主数据名称
     */
    private String dataName;
    /**
     * 数据来源-主数据编码
     */
    private String dataClassifyCode;

    /**
     * 数据来源-值名称
     */
    private String valueName;
    /**
     * 数据来源-值编码
     */
    private String valueCode;
    /**
    * 创建时间
    */
    private Long createTime;
    /**
    * 更新时间
    */
    private Long updateTime;
    /**
    * 更新人id
    */
    private Long createUserId;
    /**
    * 更新人姓名
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