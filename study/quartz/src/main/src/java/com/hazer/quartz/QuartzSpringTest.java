package com.hazer.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-10 17:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-quartz.xml")
public class QuartzSpringTest {

    @Test
    public void Test() throws InterruptedException {
        System.out.println("hello");
        Thread.sleep(100000);
    }
}
