package com.atguigu.java;

/**
 * @author wxxstar
 * @create 2023-02-25 16:29
 * 1. 创建一个继承Thread类的子类
 * 2. 重写Thread类的run()
 * 3. 创建Thread类的子类的对象
 * 4，通过此对象调用start()
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();
        System.out.println("hello");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "***" + i);
            }
        }

    }
}

/**
 * 
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "***" + i);
            }
        }
    }
}
