package com.wxx.java.sort;

/**
 * @author lhbac
 * @create 2023/5/24 21:31
 * 希尔排序
 * https://www.suanfa8.com/basic-sorting-algorithm/shell/introduction
 */
public class ShellSortTest {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int detal = len / 2; detal > 0; detal /= 2) {
            for (int start = 0; start < detal; start++) {
                insertionSortForDetal(nums, len, detal, start);
            }
        }
        return nums;
    }

    private void insertionSortForDetal(int[] nums, int len, int detal, int start) {
        for (int i = start + detal; i < len; i += detal) {
            int temp = nums[i];
            int j = i;
            for (; j - detal >= 0; j -= detal) {
                if (nums[j - detal] > temp) {
                    nums[j] = nums[j - detal];
                } else {
                    break;
                }
            }
            // 此时 nums[j - 1] <= temp
            // nums[j] 的值被赋值到了 nums[j + 1]
            nums[j] = temp;
        }
    }
}
