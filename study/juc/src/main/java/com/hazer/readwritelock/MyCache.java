package com.hazer.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-06-15 11:07
 */
public class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    //读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //写
    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        readWriteLock.readLock().lock();
        Object o = null;
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取成功");
        } catch (Exception e) {

        } finally {
            readWriteLock.readLock().unlock();
        }

        return o;
    }
}
