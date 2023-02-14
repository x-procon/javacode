package cc.procon.model.po;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 刘春发
 * @version 1.0.0
 * @ClassName IndexInfoPO.java
 * @Description TODO
 * @createTime 2022年04月14日 15:51
 */
@Data
@ToString
public class IndexInfoPO {

    private Long logId;
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

    private List<ColumnPO> columnList;

    private String tableFileds;
    /**0-新增，1-修改，2-无变化,3-索引数据初始化*/
    private Integer handleType;
    /**操作状态:1-创建中，2-创建成功，3创建失败*/
    private Integer handleStatus;
    /**修改后的新的索引名*/
    //private String newTableName;
    private Long createTime;
    private Long updateTime;
}
