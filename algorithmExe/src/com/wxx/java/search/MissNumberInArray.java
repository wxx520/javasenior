package com.wxx.java.search;

/**
 * @author wxxstar
 * @create 2023-08-07 22:17
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/58iqo5/
 */
public class MissNumberInArray {

    /**
     * @param nums
     * @return
     */
    public int missingNumberByBF(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }
        return nums[len - 1] + 1;
    }

    /**
     * 寻找连续两个数，差值大于1
     * 通过不断缩小范围，最大和最小数之差，比数组的长度小1
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        int len = nums.length;
        if (nums[len - 1] == len - 1) {
            return nums[len - 1] + 1;
        }
        int low = 0;
        int high = len - 1;
        while (high > low) {
            if (high - low == 1) {
                return nums[low] + 1;
            }

            int pivot = low + (high - low) / 2;
            if (nums[pivot] - nums[low] > pivot - low) {
                high = pivot;
            } else {
                low = pivot;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MissNumberInArray miss = new MissNumberInArray();
        System.out.println(miss.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
        System.out.println(miss.missingNumber(new int[]{0, 2, 3}));
    }
}
