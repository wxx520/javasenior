package com.wxx.java.datastructure;

/**
 * @author lhbac
 * @create 2023/7/17 21:58
 * <p>
 * https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * https://leetcode.cn/problems/sliding-window-maximum/
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class MaxSlidingWindowTest {
    /**
     * 1、返回结果数据的长度为numsLen - k + 1
     * 2、每组比较，暴力算法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowByForce(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int numsLen = nums.length;
        int[] result = new int[numsLen - k + 1];
        for (int i = 0; i < numsLen - k + 1; i++) {
            int tempMax = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                int num = nums[j];
                if (num > tempMax) {
                    tempMax = num;
                }
            }
            result[i] = tempMax;
        }
        return result;
    }

    /**
     * 理想情况：
     * 1、设计一个数据结构，从大到小排列，去掉一个数后不影响原来的顺序，新进来的数继续排序，返回最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int numsLen = nums.length;
        int[] result = new int[numsLen - k + 1];


        return result;
    }
}
