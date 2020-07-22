package com.hazer.quartz;

import org.quartz.*;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-10 10:21
 */

@DisallowConcurrentExecution
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获取任务详情
        JobDetail jobDetail = context.getJobDetail();
        //任务组
        String group = jobDetail.getKey().getGroup();
        //任务名
        String name = jobDetail.getKey().getName();

        //获取任务中的数据

        System.out.println(LocalDateTime.now() +"---job执行,任务名："+name+"任务组："
                +group);
    }
}
