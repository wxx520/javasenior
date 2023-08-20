package com.wxx.java.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lhbac
 * @create 2023/8/20 12:22
 */
public class FindKthLargestTest {

    public int findKthLargestByPriorityQueue(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            minQueue.offer(nums[i]);
        }
        for (int i = k; i < len; i++) {
            int min = minQueue.peek();
            if (nums[i] > min) {
                minQueue.poll();
                minQueue.offer(nums[i]);
            }
        }
        return minQueue.peek();
    }
}
