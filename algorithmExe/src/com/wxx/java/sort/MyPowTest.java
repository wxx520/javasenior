package com.wxx.java.sort;

/**
 * @author lhbac
 * @create 2023/5/30 15:57
 */
public class MyPowTest {

    /**
     * 暴力算法，时间复杂度n
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        boolean flag = n > 0;
        int absoluteN = flag ? n : n * (-1);
        double result = x;
        for (int i = 2; i <= absoluteN; i++) {
            result = result * x;
        }
        return flag ? result : (1.0 / result);
    }

    /**
     * 归并，自顶向下
     *
     * @param x
     * @param n
     * @return
     */
    public double myPowByTopMerge(double x, int n) {
        long N = n;
        if (N < 0) {
            return 1 / dfs(x, -N);
        }
        return dfs(x, N);
    }

    private double dfs(double x, long n) {
        if (n == 0) {
            return 1;
        }

        // n % 2 == 1 包含了 n = 1 这种情况
        if (n % 2 == 1) {
            return x * dfs(x, n - 1);
        }
        return dfs(x * x, n / 2);
    }

    /**
     * 归并自底向上
     *
     * @param x
     * @param n
     * @return
     */
    public double myPowByBottomMerge(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int N = n;
        if (n < 0) {
            N = -N;
            x = 1.0 / x;
        }
        double res = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            N = N / 2;
        }
        return res;
    }
}
