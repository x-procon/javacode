package cc.procon.model.vo;


import cc.procon.model.dto.DimDerRelationDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Desciption 维表衍生
 * @Author liuyonghua
 * @Date 2022/7/7 10:29
 **/
@Data

public class DimensionDeriveVo implements Serializable {

    /**
     * 配置名称
     */

    private String name;
    /**
     * 目标表库 1ORACLE(ODS)、2 HBASE、3ORACLE(DW)
     * {@link com.htf.enums.DimDeriveDbEnum}
     */

    private Integer targetDb;


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
     * 唯一性约束
     */

    private List<DimDeriveFieldVo> deriveUnique;
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

    private List<DimDerRelationDto> relation;
    /**
     * 运行方式 0离线 1实时
     */

    private Integer runMode;
    /**
     * 定时表达式
     */
    private String cron;
    /**
     * 说明
     */
    private String remarks;
    /**
     * 是否启用，1：是，0：否
     */
    private Integer isEnable;

    /**
     * 定时参数
     */
    private DimDeriveScheduleVo schedule;


    /**
     * 衍生视图和删除视图的来源表
     */
    private List<String> sourceTables;

    private String id;
    private Long createUserId;
    private String createUserName;
    private Long createTime;
    private Long updateUserId;
    private String updateUserName;
    private Long updateTime;
}
