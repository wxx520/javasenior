package com.atguigu.java1;

/**
 * @author wxxstar
 * @create 2023-02-25 22:10
 */
public class CommunicationTest {
}

class Number implements Runnable{
    private int number = 1;

    @Override
    public void run() {
        while (true){
            notify();
            if(number<=100){
                try {
                   Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+number);
                number++;

                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
