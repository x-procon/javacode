package com.hazer.jvm.thread;

/**
 *验证volatile在多线程中并不是线程安全的
 * @author Hazer
 * @date 2020-08-30 18:22
 */
public class VolatileTest {
    public static volatile int race = 0;
    public static void increase(){
        race++;
    }

    public static void main(String[] args) {
        Thread [] threads = new Thread[20];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() ->{
                for (int j = 0; j <10000 ; j++) {
                  increase();
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(race);
    }


}
