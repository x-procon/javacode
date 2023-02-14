package cc.procon.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desciption 分页基类
 * @Author liuyonghua
 * @Date 2022/4/14 9:13
 **/
@Data
public class BasePageRequest implements Serializable {

    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 当前页数
     */
    private Integer pageNum;

    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 排序方式，默认按自然排序(default)，中文可指定拼音排序(pinyin)
     */
    private String orderType;

    /**
     * asc 正序，desc 逆序
     */
    private String order;
}
