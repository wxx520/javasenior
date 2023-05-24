package com.wxx.java.dp;

import java.util.Arrays;

/**
 * @author wxxstar
 * @create 2023-04-20 22:38
 */
public class CoinExchangeDPTest {

    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始值为 amount + 1，或者其他特殊值
        Arrays.fill(dp, amount + 1);

        // 从base case开始解决子问题
        dp[0] = 0;
        // 每个子问题只解决一次
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);//选择最优的子问题，利用状态转移方程求父问题
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5},13));
    }
}
