package com.atguigu.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wxxstar
 * @create 2023-02-26 13:27
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
        //service1.setKeepAliveTime();
        service.execute(new NumThread2());//适合使用与Runnable
        service.submit(new NumThread1());//适合使用与Callable
        service.shutdown();
    }
}

class NumThread1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(
                        Thread.currentThread().getName()+":"+i);
                sum += i;
            }
        }
        return sum;
    }
}

class NumThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(
                        Thread.currentThread().getName()+":"+i);
            }
        }
    }
}