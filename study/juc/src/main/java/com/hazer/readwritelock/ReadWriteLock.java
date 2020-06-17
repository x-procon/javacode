package com.hazer.readwritelock;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 读锁：(共享锁)
 *               写锁: 独占锁
 * @author: Hazer
 * @date: 2020-06-12 16:57
 */
public class ReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <9 ; i++) {
            final int temp = i;
            new Thread(()->{
                list.add(temp);
            }).start();
        }
    }




}

