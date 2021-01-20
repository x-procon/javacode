package com.hazer.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @description: CountDownLatch用给定的计数初始化。
 * await方法阻塞，直到由于countDown()方法的调用而导致当前计数达到零，
 * 之后所有等待线程被释放，并且任何后续的await 调用立即返回(计数器)
 * @author: Hazer
 * @date: 2020-06-12 14:23
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(8);
        for (int i = 0; i < 8; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "go out");
                countDownLatch.countDown();
            }, "AA--" + i).start();

        }
        countDownLatch.await();
        System.out.println("close door");
    }
}
