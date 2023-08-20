package com.wxx.java.datastructure;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
     * 1、设计一个数据结构，
     * 从大到小排列，
     * 去掉一个数后不影响原来的顺序，
     * 新进来的数继续排序，返回最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowByPriorityQueue(int[] nums, int k) {
        if (k <= 1) {
            return nums;
        }
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] res = new int[n - k + 1];
        res[0] = pq.peek()[0];

        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }

    @Test
    public void t1() {
        System.out.println(Arrays.toString(maxSlidingWindowByPriorityQueue(new int[]{1, 3, 1, 2, 0, 5}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindowByPriorityQueue(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
