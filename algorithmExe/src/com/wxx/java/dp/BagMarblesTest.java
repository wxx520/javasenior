package com.wxx.java.dp;

import org.junit.Test;

import java.util.Arrays;

public class BagMarblesTest {
    public long putMarbles(int[] wt, int k) {
        int n = wt.length;
        for (int i = 0; i < n - 1; ++i) {
            wt[i] += wt[i + 1];
        }

        Arrays.sort(wt, 0, n - 1); // 相当于去掉最后一个数
        long ans = 0;
        for (int i = 0; i < k - 1; ++i)
            ans += wt[n - 2 - i] - wt[i];
        return ans;

    }

    @Test
    public void t1(){
        int[] wt = {1,4,5,2,3,0};
        Arrays.sort(wt,0,wt.length-2);
        System.out.println(Arrays.toString(wt));
            System.out.println(putMarbles(new int[]{1,4,5,2,2},3));
    }
}
