package com.hazer.jvm.classloading;

/**
 * @author Hazer
 * @date 2020-08-27 20:36
 * 通过子类引用父类静态遍历不会导致子类初始化
 * -XX:+TraceClassLoading
 */
public class SuperClass {
    static {
        System.out.println("父类初始化了！");
    }

    public static int value = 1234456;
}

class SubClass extends SuperClass {
    static {
        System.out.println("子类被初始化了！");
    }
}

class Test {
    public static void main(String[] args) {
        SubClass[] sub = new SubClass[10];
        //System.out.println(SubClass.value);
    }
}
