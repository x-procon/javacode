package cc.procon.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: htf-parent
 * @description: 通用分页检索列表
 * @author: 陈安
 * @create: 2022-04-09 17:23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonListVO {
    /**
     * 排序列
     */
    private String sortColumn;

    /**
     * 升序还是降序
     */
    private String sortOrder;

    /**页大小*/
    private Integer pageSize;

    /**页数,当前查询的页数*/
    private Integer pageNum;

    private Integer startRow;

    private Integer endRow;


    /**
     * 创建时间
     */
    private Long createTimeStart;

    /**
     * 创建时间
     */
    private Long createTimeEnd;
}
