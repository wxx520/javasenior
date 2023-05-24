package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxxstar
 * @create 2023-02-25 21:47
 */
public class ThreadLockTest {
}

class Window implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

    }
}
