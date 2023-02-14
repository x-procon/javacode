package cc.procon.model.po;

import lombok.Data;

/**
 * @author 刘春发
 * @version 1.0.0
 * @ClassName ColumnPO.java
 * @Description 表字段信息
 * @createTime 2022年04月14日 15:48
 */
@Data
public class ColumnPO {
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

    public ColumnPO() {
    }

    public ColumnPO(String name, String dataType) {
        this.name = name;
        this.dataType = dataType;
    }
}
