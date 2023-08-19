package com.wxx.java.math;

/**
 * @author wxxstar
 * @create 2023-08-11 9:43
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/572jxs/
 * https://leetcode.cn/problems/number-of-digit-one/
 * <p>
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class CountDigitOneTest {

    /**
     * 计算每个10进制位1出现的次数就是就是1最终出现的次数
     * 1、位数低于n的每个10进制位的计算方式
     * x[i] = x[i-1]+10;
     * 2、相同位数要特殊处理,3242
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        if (n < 10) {
            return 1;
        }
        int x = n;
        int[] dp = new int[10];
        dp[0] = 1;
        int denominator = 10;
        int i;
        x = x / denominator;
        for (i = 1; x >= 9; ) {
            dp[i] = 10 + dp[i - 1] * 10;
            denominator = 10 * denominator;
            i++;
            x = x / 10;
        }
        if (x == 0) {
            return dp[i - 1];
        }
        int temp = n;
        int powers = i;
        while (denominator > 1) {
            int y = temp / denominator;
            //同级处理1000-3429
            if (y > 1) {
                dp[i] = denominator + dp[powers - 1] + dp[i];
                for (int j = 1; j < y - 1; j++) {
                    dp[i] = dp[powers - 1] + dp[i];
                }
            } else if (y == 1) {
                dp[i] = temp - denominator + dp[i] + dp[powers - 1] + 1;
            }
            temp = temp - y * denominator;
            denominator = denominator / 10;
            powers--;
        }
        if (n % 10 != 0) {
            dp[i] = dp[i] + 1;
        }
        return dp[i];
    }

    public static void main(String[] args) {
        CountDigitOneTest test = new CountDigitOneTest();
        System.out.println(test.countDigitOne(20));
    }
}
