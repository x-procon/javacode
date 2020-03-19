package com.hazer.lambda;

/**
 * @ClassName LambdaTest
 * @Description TODO
 * @Author Hazer
 * @Date 2020/3/18 10:23
 **/
public class LambdaTest {
    public static void main(String[] args) {
////        Runnable t1 =  new Runnable() {
////            @Override
////            public void run() {
////
////            }
////        };

        Runnable t2 = () -> System.out.println("eeee");
        t2.run();
    }

}
