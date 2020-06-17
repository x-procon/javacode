package com.hazer.threadpool;

import java.util.concurrent.*;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-06-17 13:47
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
        ExecutorService executor = new ThreadPoolExecutor(2,processors,3L, TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 100000; i++) {
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"---ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}
