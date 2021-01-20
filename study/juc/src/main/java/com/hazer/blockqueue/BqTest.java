package com.hazer.blockqueue;

import jdk.nashorn.internal.ir.Block;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description: 堵塞队列测试
 * @author: Hazer
 * @date: 2020-06-12 16:31
 */
public class BqTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        //add remove 抛出异常
//        blockingQueue.add("aa");
//        System.out.println(blockingQueue);
//        blockingQueue.add("bb");
//        System.out.println(blockingQueue);
//        blockingQueue.add("cc");
//        System.out.println(blockingQueue.element());
//
//        blockingQueue.remove();
//        System.out.println(blockingQueue);
//        blockingQueue.remove();
//        System.out.println(blockingQueue);
//        blockingQueue.remove();

        // put take 队列没位置会阻塞
//        blockingQueue.put("aa");
//        System.out.println(blockingQueue);
//        blockingQueue.put("bb");
//        System.out.println(blockingQueue);
//        blockingQueue.put("cc");
//        System.out.println(blockingQueue.element());
//        blockingQueue.put("dd");
//
//        blockingQueue.take();
//        System.out.println(blockingQueue);
//        blockingQueue.take();
//        System.out.println(blockingQueue);
//        blockingQueue.take();

        blockingQueue.offer("aa");
        System.out.println(blockingQueue);
        blockingQueue.offer("bb", 2, TimeUnit.SECONDS);
        System.out.println(blockingQueue);
        blockingQueue.offer("cc");
        System.out.println(blockingQueue.offer("dd"));
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue);
        blockingQueue.poll();
        System.out.println(blockingQueue);
        blockingQueue.poll();

    }
}
