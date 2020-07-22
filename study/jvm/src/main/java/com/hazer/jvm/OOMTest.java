package com.hazer.jvm;

import org.junit.Test;
import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Java堆内存溢出异常测试
 * @author: Hazer
 * @date: 2020-07-15 11:05
 * -verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 */
public class OOMTest {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    /**
     * -Xss200k
     * @param: []
     * @return: void
     */
    @Test
    public void JavaVMStackSOF(){
        OOMTest oom = new OOMTest();
        try {
            oom.stackLeak(1);
        } catch (Throwable e) {
            throw e;
        }
    }



    public void stackLeak(int stackLength) {
        stackLength++;
        stackLeak(stackLength);

    }
}
