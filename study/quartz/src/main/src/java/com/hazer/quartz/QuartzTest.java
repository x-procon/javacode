package com.hazer.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.GregorianCalendar;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-10 10:32
 */

public class QuartzTest {
    public static void main(String[] args) {
        try {
            //创建一个调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //创建一个触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            //设置触发器名称和组
            triggerBuilder.withIdentity("myTrigger", "myTriggerGroup");
            //一旦加入scheduler立刻执行
            triggerBuilder.startNow();
            //每秒执行一次
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"));
            //设置结束时间
            triggerBuilder.endAt(new GregorianCalendar(2020, 7, 10, 14, 19, 0).getTime());
            Trigger trigger = triggerBuilder.build();
            //定义一个jobDetail
            JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                    .withIdentity("task", "taskGroup")
                    .usingJobData("data", "---测试数据---")
                    .build();
            //调度器中加入任务和触发器
            scheduler.scheduleJob(jobDetail, trigger);
            Thread.sleep(9000);
            //启动
            scheduler.start();


        } catch (SchedulerException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
