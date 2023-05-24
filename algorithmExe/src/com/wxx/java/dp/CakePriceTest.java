package com.wxx.java.dp;

/**
 * @author wxxstar
 * @create 2023-05-14 16:19
 * 输入蛋糕价格列表 priceList ，求重量为 n 蛋糕的最高售价
 */
public class CakePriceTest {



    static  int maxCakePrice(int n, int[] priceList) {
        if (n <= 1) return priceList[n]; // 蛋糕重量 <= 1 时直接返回
        int f_n = 0;
        for (int i = 0; i < n; i++)      // 从 n 种组合种选择最高售价的组合作为 f(n)
            f_n = Math.max(f_n, maxCakePrice(i, priceList) + priceList[n - i]);
        return f_n;                      // 返回 f(n)
    }
}
