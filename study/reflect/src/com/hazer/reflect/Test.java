package com.hazer.reflect;

/**
 * @Program: javacode
 * @Description:
 * @Author: Hazer
 * @Date: 2020-04-14 13:59
 */
public class Test {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("com.hazer.reflect.User");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
