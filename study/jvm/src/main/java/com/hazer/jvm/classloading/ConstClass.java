package com.hazer.jvm.classloading;

/**
 * @author Hazer
 * @description 常量在编译阶段会存入常量池中,不会再初始化
 * @date 2020-08-28 09:14
 */
public class ConstClass {
    static {
        System.out.println("类被初始化了！");
    }
    public static final String HELLO_WORLD="hello world";

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c == (a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g == (a+b));
        System.out.println(g.equals(a+b));

        Integer i = 6;
        System.out.println(System.identityHashCode(i));
        i = 7;
        System.out.println(System.identityHashCode(i));

    }
}

