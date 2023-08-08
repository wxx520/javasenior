package com.wxx.java.search;

import java.util.Arrays;
import java.util.zip.Deflater;

/**
 * @author wxxstar
 * @create 2023-08-06 21:37
 */
public class FindMinNumberInRotatedArray {

    /**
     * 要找到左边比自己大，右边也不比自己小，就是最小数
     * 二分法查找：
     * flag：
     * 如果
     * i==flag==j，说明整个数组相等
     * i<=flag, flag>j，说明在右边，i=flag-1
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        if (nums[0] < nums[len - 1]) {
            return nums[0];
        }

        int low = 0, high = len - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }

        }
        return nums[low];

    }

    public int findMinByBruteForce(int[] nums) {
        int min = nums[0];
        for (int n : nums) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }
}
