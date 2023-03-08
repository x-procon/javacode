package cc.procon.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TDampOdsDimensionFiled)实体类
 *
 * @author 陈安
 * @since 2022-04-08 14:57:41
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DimensionFiledPO implements Serializable {
    private static final long serialVersionUID = 491605603093629259L;
    /**
    * 主键
    */
    private String id;
    /**
    * 维表id
    */
    private String tableId;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 字段名称
    */
    private String name;
    /**
    * 字段中文名
    */
    private String cnName;
    /**
    * 数据类型
    */
    private String dataType;
    /**
    * 数据长度
    */
    private Integer dataLength;
    /**
    * 是否可为空，1：是，0：否
    */
    private Integer isNullable;
    /**
    * 数据精度
    */
    private Integer dataAccuracy;
    /**
    * 数据保存格式
    */
    private String dataFormat;
    /**
    * 备注
    */
    private String remarks;
    /**
    * 是否启用
    */
    private Integer isEnable;
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