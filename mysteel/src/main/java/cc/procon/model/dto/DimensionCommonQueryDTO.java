package cc.procon.model.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author fanzhibiao
 */
@Getter
@Setter
@ToString
public class DimensionCommonQueryDTO extends BaseQueryDTO {
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
     * 是否对外提供
     */
    private Integer isForeign;

    /**
     * 是否启用
     */
    private Integer isEnable;

    /**
     * 框架id
     */
    private String frameId;

    /**
     * 维表名称集合
     */
    private List<String> upperTableNameList;

    /**
     * 框架id集合
     */
    private List<String> frameIdList;

    /**
     * 维表id集合
     */
    private List<String> dimensionIdList;

    /**
     * 关键字
     * 全模糊匹配维表中英文名称
     */
    private String keyword;

    /**
     * 是否包含删除 1-包含 其他-不包含删除（即只要未删除的数据）
     */
    private Integer includeDelete;

    /**
     * 数据来源-主数据名称
     */
    private String dataName;

    /**
     * 数据来源-值名称
     */
    private String valueName;

    /**
     * 落地库类型（1:oracle,2:Hbase,-1:未知）
     */
    private Integer sourceType;
}