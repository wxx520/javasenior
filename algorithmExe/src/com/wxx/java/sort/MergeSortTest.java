package com.wxx.java.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lhbac
 * @create 2023/5/30 20:10
 */
public class MergeSortTest {

    @Test
    public void t1() {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
    }

    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, nums.length - 1, temp);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 将nums逐渐分为2组，直至每组的元素个数为1，然后进行两组排序，再逐级向上合并排序，最终完成排序
     * 初始化
     *
     * @param nums
     * @param left
     * @param right
     */
    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (right - left < 16) {
            insertionSort(nums, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        // 优化 2：如果数组已经有序，无须再合并
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeTwoSortedArray(nums, left, mid, right, temp);
    }

    private void insertionSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        for (int i = left + 1; i <= right; i++) {
            int base = nums[i];
            int j;
            for (j = i; j > left && (nums[j - 1] > base); j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = base;

        }
    }

    public void mergeTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }


        int i = left;
        int j = mid + 1;
        //[left,mid]
        //[mid+1,right]
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > right) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }


    /**
     * 自底向上的归并排序，使用迭代就可以完成
     */
    public void mergeTwoSortedArray1(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int size = 1; size <= n; size += size) {
            for (int k = 0; k + size < n; k += size + size) {
                mergeTwoSortedArray(nums, k, k + size - 1, Integer.min(k + size + size - 1, n - 1),temp);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void t2() {
        int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        mergeTwoSortedArray1(arr);
    }

}
