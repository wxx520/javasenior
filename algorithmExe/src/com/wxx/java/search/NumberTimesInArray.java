package com.wxx.java.search;

import java.util.Arrays;

/**
 * @author wxxstar
 * @create 2023-08-07 9:42
 * <p>
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5874p1/
 */
public class NumberTimesInArray {


    /**
     * 找出左边比目标值大右边比目标值小的两个数的索引，索引之差就是结果
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int len = nums.length;
        if (len == 0 || target < nums[0] || target > nums[len - 1]) {
            return 0;
        }

        if (len == 1) {
            return nums[0] == target ? 1 : 0;
        }
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            if (low == high) {
                return nums[low] == target ? 1 : 0;
            }
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < target) {
                low = pivot + 1;
            } else if (nums[pivot] > target) {
                high = pivot;
            } else {
                int left = leftIndex(nums, target, low, pivot);
                int right = rightIndex(nums, target, pivot, high);
                return right - left + 1;
            }
        }
        return 0;
    }

    /**
     * 左半边的数只会<=target
     *
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    private int leftIndex(int[] nums, int target, int low, int high) {
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < target) {
                low = pivot + 1;
            } else if (nums[pivot] == target) {
                high = pivot;
            }
        }
        return high;
    }

    /**
     * 右半边的数只会>=target
     *
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    private int rightIndex(int[] nums, int target, int low, int high) {
        while (low < high) {
            //当high-low=1时pivot总是等于low，会进入死循环
            if (high - low == 1) {
                return nums[high] == target ? high : low;
            }

            int pivot = low + (high - low) / 2;
            if (nums[pivot] > target) {
                high = pivot - 1;
            } else if (nums[pivot] == target) {
                low = pivot;
            }
        }

        return low;

    }

    public static void main(String[] args) {
        int[] arr = {6,6,6};
        System.out.println(new NumberTimesInArray().search(arr, 6));
    }
}
