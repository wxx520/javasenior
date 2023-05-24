package com.wxx.java.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/ozzl1r/
 * https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class DicesProbabilityTest {
    /**
     * n个骰子在投掷时的点数之和为m，n<=m<=6n且从n到6n递增，则n个骰子点数之和的种数为6n-n+1=5n+1个，即所求浮点数组props的长度为5n+1；
     * 假设dp[n][m]表示n个骰子的和为m的组合数,则其中一个骰子可能的点数为[1-6](暂时不考虑边界情况)，故有如下状态转移方程
     * dp[n][m] = dp[n-1][m-1]+dp[n-2][m-2]+dp[n-1][m-3]+..d[n-1][m-i]..++d[n-1][m-6] n>=1,m>=1*n,1<=i<=6
     *
     * 最后一个骰子点数边界[min,max]情况：
     * 对于i个骰子的点数之和为j，
     * 1、最后一个筛子的最小值min一定是在i-1个筛子取最大值的时候出现的，即min = j-6(i-1)，当j-6(i-1)<1时，即i-1个骰子不能都取最大值6的时候，此时min取1，
     *     min = Math.max(1,6*(i-1));
     *   如对于2个骰子和为9的情况，最后一个骰子最小值为2；
     *   如对于2个骰子和为4的情况，最后一个骰子最小值为1；
     * 2、最后一个筛子的最大值max一定时在i-1个筛子取最小值的时候出现的，即max = j-(i-1)，当j-6(i-1)>6时，即i-1个骰子不能都取最小值的时候，此时max取6，
     *     min = Math.min(6,j-i+1));
     *   如对于2个骰子和为5的情况，最后一个骰子最大值为4；
     *   如对于2个骰子和为9的情况，最后一个骰子最小值为6；
     * 3、则：
     *   dp[n][m] = dp[n-1][m-min]+..d[n-1][m-i]..++d[n-1][m-max] n>=1,m>=1*n,min<=i<=max
     *
     *
     * 初始值
     * d[1][i] = 1,1<=i<=6;
     *
     * 每个筛子出现指定数字的概率是1/6,则n个筛子出现指定点数的概率是p0=(1/6)^n,n骰子在投掷时的点数之和为m的概率为： p0 乘 骰子的组合数 = p0*d[n][m]；
     * 记浮点数数组为props，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     * 即 props[i] = p0*dp[n][n+i]
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n+1][6*n+1];
        Arrays.fill(dp[1],1);
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <=6*i ; j++) {
                //考虑第j个骰子的边界情况
                int min = Math.max(1,j-6*i+6);//对于点数之和j，最后一个骰子的点数最小值为Math.max(1,j-6(i-1));
                int max = Math.min(6,j-i+1);///对于点数之和j，最后一个骰子的点数最大值为Math.min(6,j-(i-1));
                for (int k=min; k <= max; k++) {
                    dp[i][j] =dp[i][j]+dp[i-1][j-k];
                }
            }
        }

        double[] props = new double[5*n+1];
        double specificNumProps = Math.pow(1.0/6.0,n);
        for (int i = 0; i < 5*n+1; i++) {
            props[i] = specificNumProps * dp[n][i+n];
        }
        return props;
    }

    @Test
    public void t1(){
        System.out.println(Arrays.toString(dicesProbability(3)));
    }
}
