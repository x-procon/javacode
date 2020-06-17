package com.hazer.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: Callable使用,FutureTask的使用
 * @author: Hazer
 * @date: 2020-06-12 14:01
 */
public class CallableTest implements Callable<String>{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new CallableTest());
        Thread a = new Thread(futureTask, "A");
        a.start();
        String s = futureTask.get();
        System.out.println(s);
    }

    @Override
    public String call() {
        System.out.println("我是你爹");
        return "10086";
    }
}
