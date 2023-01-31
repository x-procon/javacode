package cc.procon.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desciption 验证字段关系
 * @Author liuyonghua
 * @Date 2022/7/7 10:32
 **/
@Data
public class DimDerRelationDto implements Serializable {


    /**
     * 源表
     */
    private String sourceTable;
    /**
     * 目标字段
     */
    private String targetField;
    /**
     * 目标字段中文名(目标字段)
     */
    private String targetFieldLable;
    /**
     * 字段类型
     */
    private String fieldType;
    /**
     * 与目标字段对应的源字段
     */
    private String relSource;

    public DimDerRelationDto() {
    }

    public DimDerRelationDto(String targetField, String relSource) {
        this.targetField = targetField;
        this.relSource = relSource;
    }
}
