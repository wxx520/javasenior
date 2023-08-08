package com.wxx.java.search;

import java.util.Arrays;

/**
 * @author wxxstar
 * @create 2023-08-07 22:07
 *
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class NumberTimesIndexInArray {

    /**
     * 找出左边比目标值大右边比目标值小的两个数的索引，索引之差就是结果
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] search(int[] nums, int target) {

        int len = nums.length;
        if (len == 0 || target < nums[0] || target > nums[len - 1]) {
            return new int[]{-1,-1};
        }

        if (len == 1) {
            return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        }
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            if (low == high) {
                return nums[low] == target ? new int[]{low,low} : new int[]{-1,-1};
            }
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < target) {
                low = pivot + 1;
            } else if (nums[pivot] > target) {
                high = pivot;
            } else {
                int left = leftIndex(nums, target, low, pivot);
                int right = rightIndex(nums, target, pivot, high);

                return new int[]{left,right};
            }
        }
        return new int[]{-1,-1};
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
        NumberTimesIndexInArray n = new NumberTimesIndexInArray();
        System.out.println(Arrays.toString(n.search(new int[]{3,3,3},3)));
    }
}
