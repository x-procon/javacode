package com.hazer.jvm.classloading;

/**
 * @author Hazer
 * @description
 * @date 2020-08-28 09:17
 * -XX:+TraceClassLoading
 */
public class NotInitClass {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO_WORLD);
    }

}
