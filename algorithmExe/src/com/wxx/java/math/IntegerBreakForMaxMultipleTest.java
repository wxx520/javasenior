package com.wxx.java.math;

/**
 * @author wxxstar
 * @create 2023-08-08 9:22
 * https://leetcode.cn/problems/integer-break/
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5v1026/
 * <p>
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * <p>
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class IntegerBreakForMaxMultipleTest {

    /**
     * 尽量均匀的拆成m份，每份差值不超过1，
     * 每份从1开始分，并计算乘积，若随着m减少，乘积没有增大，则最近就是最大乘积
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 3) {
            return n-1;
        }
        int multipleResult = 1;
        for (int i = 2; i < n; i++) {
            int m = n / i;
            int remainder = n % i;
            if (m < 2&&remainder==0) {
                break;
            }
            int tmpResult = 1;
            if (i - remainder == 1) {
                tmpResult = remainder;
                remainder = 0;
            }
            for (int j = 0; j < m; j++) {
                int factor = i;
                if (remainder > 0) {
                    remainder--;
                    factor = i + 1;
                }
                tmpResult = (tmpResult * factor);
            }
            if (tmpResult > multipleResult) {
                multipleResult = tmpResult;
            } else {
                return multipleResult;
            }

        }
        return multipleResult;
    }

    public int integerBreakByDp(int n) {
        return 1;
    }

    public static void main(String[] args) {
        IntegerBreakForMaxMultipleTest test = new IntegerBreakForMaxMultipleTest();
        System.out.println(test.integerBreak(8));
    }
}
