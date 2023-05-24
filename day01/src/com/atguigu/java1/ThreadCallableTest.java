package com.atguigu.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wxxstar
 * @create 2023-02-25 23:25
 */
class NumThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadCallableTest {
    public static void main(String[] args) {
        NumThread numThread =new NumThread();
        FutureTask<Integer> fk = new FutureTask(numThread);
        new Thread(fk).start();
        try {
            Integer sum = fk.get();
            System.out.println("总和为："+sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
