package com.atguigu.java1;

/**
 * @author wxxstar
 * @create 2023-02-25 21:24
 */
public class ThreadSingletonTest {
}

class Bank {
    private Bank() {
    }


    private static Bank instance = null;

    /*
    * 锁是Bank.class
    *
    * */
    public static synchronized Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public static Bank getInstance1() {
        /*synchronized (Bank.class){
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
        }*/
        if(instance==null){
            synchronized (Bank.class){
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
