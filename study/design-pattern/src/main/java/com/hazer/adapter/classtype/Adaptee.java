package com.hazer.adapter.classtype;

/**
 * @description: 需要适配适配者
 * @author: Hazer
 * @date: 2020-07-06 10:29
 */
public class Adaptee {
    /**
     * 具体的调用类
     * @param: []
     * @return: void
     */
    public void specificRequest(){
        System.out.println("适配者中的业务代码被调用");
    }
}
