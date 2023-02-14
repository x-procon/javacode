package cc.procon.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 刘春发
 * @version 1.0.0
 * @ClassName IndexLogRequest.java
 * @Description 维表初始化请求对象
 * @createTime 2022年04月19日 10:12
 */
@Data
//@ToString
public class IndexInitRequest extends BasePageRequest {

    private String tableName;
    /**维表ID*/
    private String id;
    /**是否需要重建索引，默认false*/
    private boolean createIndex;
    /**
     * 是否删除，1：是，0：否
     */
    private Integer isDelete;
    /**
     * 是否启用，1：是，0：否
     */
    private Integer isEnable;

    private String columns;
    /**补偿周期*/
    private String period;
    /**
     * 补偿使用单个指标编码查询，增加查询效率,不接受接口调用传参，需要的话传indexCodeList
     */
    private String indexCode;
    /**增量补偿使用*/
    List<String> indexCodeList;
    /**补偿开始时间*/
    private Long startTime;
    /**补偿结束时间*/
    private Long endTime;
    /**按分区初始化,指定分区就不需要使用指标编码查询，两者冲突*/
    private String dataPartition;

    private Integer type;

    public IndexInitRequest() {
    }

    public IndexInitRequest(String tableName, String id) {
        this.tableName = tableName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "IndexInitRequest{" +
                "tableName='" + tableName + '\'' +
                ", id='" + id + '\'' +
                ", createIndex=" + createIndex +
                ", isDelete=" + isDelete +
                ", isEnable=" + isEnable +
                ", columns='" + columns + '\'' +
                ", period='" + period + '\'' +
                ", indexCode='" + indexCode + '\'' +
                ", indexCodeList=" + indexCodeList +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                "} " + super.toString();
    }
}
