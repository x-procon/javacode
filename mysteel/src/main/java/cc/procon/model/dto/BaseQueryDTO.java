package cc.procon.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author fanzhibiao
 */
@Getter
@Setter
@ToString
public class BaseQueryDTO implements Serializable {
    private static final long serialVersionUID = 166456843981039290L;

    /** 创建时间-开始 */
    private Long startTime;

    /** 创建时间-结束 */
    private Long endTime;

    /** 排序字段 */
    private String sortColumn;

    /** 排序 desc/asc */
    private String sortOrder;

    private Integer offset;

    private Integer rows;

    private Integer startRow;

    private Integer endRow;

    private Integer number;

    private Integer size;
}
