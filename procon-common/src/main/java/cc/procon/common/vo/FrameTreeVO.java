package cc.procon.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 维表框架 框架树
 *
 * @author fanzhibiao
 */
@Getter
@Setter
@ToString
public class FrameTreeVO implements Serializable {
    private static final long serialVersionUID = 166456843981039290L;

    /** 框架id */
    private String id;

    /** 框架名称 */
    private String cnName;

    /**
     * 父级框架id
     */
    private String pid;

    /** 框架全路径 */
    private String framePath;

    /** 框架id全路径 */
    private String frameIdPath;

    /** 排序 */
    private Float sort;

    /**
     * 是否有子级
     */
    private Integer hasChild;

    /**
     * 框架层级
     */
    private Integer frameLevel;
    /**
     * 唯一code
     */
    private String tableCode;

    /** 状态0-禁用 1-启用 */
    private Integer isEnable;
    /**
     * 子级框架,api-control用
     */
    private List<FrameTreeVO> children;
    /**
     * 该框架下是否有关联维表/指标，命名与其他层保持一致
     * true-无关联 false-关联
     */
    private Boolean enAbleSelect;
    private String cnNameTableCode;

    /**
     *框架下的指标数量
     */
    private Integer indexNum;

}
