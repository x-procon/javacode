package com.hazer.readwritelock;

import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @description: 读锁：(共享锁)
 *               写锁: 独占锁
 * @author: Hazer
 * @date: 2020-06-12 16:57
 */
public class ReadWriteLock {
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     *读锁
     */
    private final ReadLock readLock = readWriteLock.readLock();
    /**
     * 写锁
     */
    private final WriteLock writeLock = readWriteLock.writeLock();

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

