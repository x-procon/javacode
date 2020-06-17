package com.hazer.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-06-12 15:08
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙成功");
        });
        for (int i = 1; i <=7 ; i++) {
            final int temp = i;
            Thread a = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集" + temp + "个龙珠！");

                try {

                    cyclicBarrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i));
            a.start();

        }
        
    }
}
