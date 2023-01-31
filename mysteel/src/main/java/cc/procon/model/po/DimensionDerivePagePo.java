package cc.procon.model.po;

import lombok.Data;



/**
 * 维表衍生分页的po,过滤部分大文本字段
 */
@Data
public class DimensionDerivePagePo extends DampBasePo{

        /**
     * 配置名称
     */
    private String name;
    /**
     * 目标表库 1ORACLE(ODS)、2 HBASE、3ORACLE(DW)
     */
    private Integer targetDb;
    /**
     * 源表库 1ORACLE(ODS)、2 HBASE、3ORACLE(DW)
     */
    private Integer sourceDb;
    /**
     * 目标表id
     */
    private String targetTableId;
    /**
     * 目标表名
     */
    private String targetTableName;
    /**
     * 目标表中文名
     */
    private String targetTableCnName;
    /**
     * 是否启用，1：是，0：否
     */
    private Integer isEnable;

    /**
     * 运行方式 0离线 1实时
     */
    private Integer runMode;
}