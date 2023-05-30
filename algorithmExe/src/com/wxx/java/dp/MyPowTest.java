package com.wxx.java.dp;

import org.junit.Test;

/**
 * @author lhbac
 * @create 2023/5/30 15:57
 */
public class MyPowTest {

    public double myPow(double x, int n) {
        boolean flag = n > 0;
        int absoluteN = flag ? n : n * (-1);
        double result = x;
        for (int i = 2; i <= absoluteN; i++) {
            result = result * x;
        }
        return flag?result:(1.0/result);
    }

    @Test

}
