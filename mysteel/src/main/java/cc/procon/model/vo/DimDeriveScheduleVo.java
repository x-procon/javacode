package cc.procon.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desciption 定时参数
 * @Author liuyonghua
 * @Date 2022/7/7 10:35
 **/
@Data
public class DimDeriveScheduleVo implements Serializable {

    /**
     * 维表衍生配置id
     */
    private String deriveId;
    /**
     * 时间频度（1、日度2、周度 3、月度 4、自定义）
     */
    private Integer frequency;
    /**
     * 生成方式（1、法定工作日/2、每日，
     1、周一/2、周二/3、周三/4、周四/5、周五/6、周六/7、周天，1、自然日（选择日期）/2、最后一日，自定义周期时间）
     */
    private String timeGenMode;
    /**
     * 周期时间（作用范围：日度/周度/月度）
     */
    private String scheduleTime;
    /**
     * 截止时间（作用范围：日度/周度/月度/自定义）
     */
    private Long endTime;
    /**
     * 开始时间（作用范围：自定义）
     */
    private Long startTime;
    /**
     * 超过时间 startTime + overTime = endTime
     */
    private String overTime;
    /**
     * 是否跳过周末(0、跳过 1、不跳过（作用范围：日度）)
     */
    private Integer isSkipWeekend;
}
