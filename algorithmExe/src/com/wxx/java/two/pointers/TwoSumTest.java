package com.wxx.java.two.pointers;

/**
 * @author wxxstar
 * @create 2023-09-02 14:00
 *
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class TwoSumTest {

    public int[] twoSumByBF(int[] numbers, int target) {
        int i1 = -1, i2 = -1;
        int len = numbers.length;
        for (int i = 1; i <= len; i++) {
            int num = numbers[i - 1];
            int j = i + 1;
            while (j <= len) {
                int another = numbers[j - 1];
                if (another == target - num) {
                    i1 = i;
                    i2 = j;
                    return new int[]{i1, i2};
                } else if (another > target - num) {
                    break;
                } else {
                    j++;
                }
            }

        }
        return null;
    }

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int start = 0, end = len - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                break;
            }
            while (numbers[end] > target - numbers[start]) {
                end--;
            }
            while (numbers[start] < target - numbers[end]) {
                start++;
            }
        }
        return new int[]{start + 1, end + 1};
    }
}
