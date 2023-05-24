package com.atguigu.java1;

/**
 * @author wxxstar
 * @create 2023-02-25 21:33
 */
public class ThreadDeadLockTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s2.append("1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");
                    }

                }

            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("3");
                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");
                    }

                }
            }
        }).start();
    }
}
