package com.atguigu.exer;

/**
 * @author wxxstar
 * @create 2023-02-25 16:46
 * 联系：创建两个分线程，骑宠一个线程便利100以内的偶数，另外一个线程便利100的奇数
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new MyThread1(1).start();
        new MyThread1(0).start();
    }
}

class MyThread1 extends Thread{
    private int fenmu;

    public  MyThread1(){

    }

    public MyThread1(int fenmu){
        this.fenmu = fenmu;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == fenmu) {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}