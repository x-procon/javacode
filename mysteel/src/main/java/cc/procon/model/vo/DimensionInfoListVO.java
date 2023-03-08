package cc.procon.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (TDampOdsDimensionInfo)VO
 *
 * @author chenan
 * @since 2022-04-08 15:23:27
 */
@Data
public class DimensionInfoListVO extends CommonListVO implements Serializable {
    private static final long serialVersionUID = 166456843981039290L;

    private Long userId;
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
     * 框架id
     */
    private String frameId;
    /**
    * 维表唯一code
    */
    private String tableCode;
    /**
     * 是否对外提供
     */
    private Integer isForeign;

    /**
    * 是否删除，0：否，1：是
    */
    private Integer isDelete;
    /**
    * 是否启用，1：启用，0：未启用
    */
    private Integer isEnable;

    /**
    * 记录第三方数据源(1.钢联2xxxx
    */
    private Integer dataSource;
    /**
    * 数据来源原表名称用逗号分隔
    */
    private String sourceTableName;
    /**
    * 创建时间
    */
    private Long createTime;

    /**
    * 更新人姓名
    */
    private String createUserName;

    /**
     * 框架id集合
     */
    private List<String> frameIdList;

    /**
     * 落地库类型（1:oracle,2:Hbase,-1:未知）
     */
    private Integer sourceType;
}