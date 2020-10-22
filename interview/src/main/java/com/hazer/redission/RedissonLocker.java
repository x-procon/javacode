package com.hazer.redission;

import java.util.concurrent.TimeUnit;

/**
 * <p>描述</p>
 *
 * @author hazer
 * @version 1.0
 * @date 2020-10-09
 */
public class RedissonLocker implements Locker {
    @Override
    public void lock(String lockKey) {

    }

    @Override
    public void unlock(String lockKey) {

    }

    @Override
    public void lock(String lockKey, int timeout) {

    }

    @Override
    public void lock(String lockKey, TimeUnit unit, int timeout) {

    }

    @Override
    public boolean tryLock(String lockKey) {
        return false;
    }

    @Override
    public boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public boolean isLocked(String lockKey) {
        return false;
    }
}
