package com.hazer.forkjoin;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @description: 一个人
 * @author: Hazer
 * @date: 2020-06-15 13:36
 */
public class ForkJoinTest extends RecursiveTask<Long> {

    Long start = 0L;
    Long end = 1_000_000_000L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinTest forkJoinTest = new ForkJoinTest();
        //forkJoinTest.add();  //结果：500000000500000000共耗时6144毫秒
        forkJoinTest.add2();
        //forkJoinTest.add3();   //结果：500000000500000000共耗时224毫秒
    }

    public Long add() {
        Long count = 0L;
        LocalDateTime startTime = LocalDateTime.now();
        for (Long i = 0L; i <= 1_000_000_000L; i++) {
            count = count + i;
        }
        LocalDateTime endTime = LocalDateTime.now();
        Duration between = Duration.between(startTime, endTime);
        long millis = between.toMillis();
        System.out.println("结果：" + count + "共耗时" + millis + "毫秒");
        return count;
    }


    public Long add2() throws ExecutionException, InterruptedException {
        LocalDateTime startTime = LocalDateTime.now();
        ForkJoinTest task = new ForkJoinTest(0L, 1_000_000_000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //forkJoinPool.execute(task);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task); //提交任务有结果
        Long count = submit.get();
        LocalDateTime endTime = LocalDateTime.now();
        Duration between = Duration.between(startTime, endTime);
        long millis = between.toMillis();
        System.out.println("结果：" + count + "共耗时" + millis + "毫秒");
        return count;
    }

    @Override
    protected Long compute() {

        Long temp = 10000L;
        if (end - start < temp) {
            return add();
        } else {
            Long middle = (end + start) / 2;
            ForkJoinTest forkJoinTest = new ForkJoinTest(start, middle);
            forkJoinTest.fork();
            ForkJoinTest forkJoinTest2 = new ForkJoinTest(middle + 1, end);
            forkJoinTest2.fork();
            return forkJoinTest.join() + forkJoinTest2.join();
        }


    }


    public void add3() {
        LocalDateTime startTime = LocalDateTime.now();
        Long reduce = LongStream.rangeClosed(0, 1_000_000_000).parallel().reduce(0, Long::sum);
        LocalDateTime endTime = LocalDateTime.now();
        Duration between = Duration.between(startTime, endTime);
        long millis = between.toMillis();
        System.out.println("结果：" + reduce + "共耗时" + millis + "毫秒");
    }

    public ForkJoinTest() {
    }

    public ForkJoinTest(Long start, Long end) {
        this.start = start;
        this.end = end;
    }
}
