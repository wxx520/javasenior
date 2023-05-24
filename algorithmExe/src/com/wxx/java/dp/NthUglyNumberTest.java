package com.wxx.java.dp;

import org.junit.Test;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 */
public class NthUglyNumberTest {

    /**
     *
     * 设已知长度为x(1),x(2),...,x(i)，则有x(i+1) = min(x(a)*2,x(b)*3,x(c)*5);
     * 由于x(i+1)时最接近x(i)的丑数，a，b，c有如下关系
     *      x(a)*2>x(i)>=x(a-1)*2;
     *      x(b)*3>x(i)>=x(b-1)*3;
     *      x(c)*5>x(i)>=x(c-1)*5;
     *则尝试递推：
     * x(1)=1;
     * 假设a=1,b=1,c=1
     * 当i=2时,x(2)=x(1)*2=min(x(1)*2,x(1)*3,x(1)*5);命中a=1
     * 当i=3时,x(3)=x(1)*3=min(x(1)*2,x(1)*3,x(1)*5);命中b=1
     * 当i=4时,x(4)=x(2)*2=min(x(1)*2,x(1)*3,x(1)*5);命中a=2
     * 当i=5时,x(5)=x(1)*5=min(x(1)*2,x(1)*3,x(1)*5);命中c=1
     * 当i=6时,x(6)=x(3)*2=min(x(1)*2,x(1)*3,x(1)*5);命中b=2
     * 当i=8时,x(7)=x(4)*2=min(x(1)*2,x(1)*3,x(1)*5);命中a=2
     */
    public int nthUglyNumber(int n){
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];

    }

    public boolean isUglyNumber(int x){
        int temp = x;

        while (temp>1){
            int before = temp;
            if(temp%2==0){
                temp = temp/2;
            }
            if(temp%3==0){
                temp = temp/3;
            }
            if(temp%5==0){
                temp = temp/5;
            }
            if(temp>1&&temp==before){
                return false;
            }
        }
        return true;
    }

    @Test
    public void t1(){
        System.out.println(isUglyNumber(10));
        System.out.println(isUglyNumber(11));
        System.out.println(nthUglyNumber(15));
    }

}
