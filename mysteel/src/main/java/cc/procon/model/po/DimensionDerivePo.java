package cc.procon.model.po;

import lombok.Data;



@Data
public class DimensionDerivePo extends DimensionDerivePagePo{


    /**
     * 唯一性约束
     */
    private String deriveUnique;
    /**
     * 衍生视图
     */
    private String deriveView;
    /**
     * 删除视图
     */
    private String deleteView;
    /**
     * 关联关系
     */
    private String relation;
    /**
     * 定时表达式
     */
    private String cron;
    /**
     * 说明
     */
    private String remarks;


}