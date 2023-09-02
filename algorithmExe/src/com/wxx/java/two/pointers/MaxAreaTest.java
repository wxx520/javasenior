package com.wxx.java.two.pointers;

import org.junit.Test;

/**
 * @author wxxstar
 * @create 2023-09-02 14:54
 * <p>
 * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxAreaTest {

    /**
     * (i,0)(i,height[i])与(j,0)(j,height[j])两条线段和x轴面积最大化
     *
     * (x-1)y=xy-y x(y-1)=xy-y
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int start = 0;
        int len = height.length;
        int end = len - 1;
        int maxArea = 0;
        while (start < end) {
            if (height[end] >= height[start]) {
                maxArea = Math.max((end - start) * height[start], maxArea);
                start++;
                continue;
            }

            maxArea = Math.max((end - start) * height[end], maxArea);
            int tempEnd = end - 1;
            int maxY = height[end];
            while (tempEnd > start) {
                if (height[tempEnd] >= height[start]) {
                    maxArea = Math.max((tempEnd - start) * height[start], maxArea);
                    break;
                } else if (height[tempEnd] < maxY) {
                    tempEnd--;
                } else {
                    maxArea = Math.max((tempEnd - start) * height[tempEnd], maxArea);
                    tempEnd--;
                }
            }
            start++;

        }

        return maxArea;
    }

    @Test
    public void t1() {
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
