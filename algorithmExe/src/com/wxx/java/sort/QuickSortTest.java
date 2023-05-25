package com.wxx.java.sort;

/**
 * @author wxxstar
 * @create 2023-05-25 16:31
 * <p>
 * 快速排序
 * 分而治之的特例：减而治之
 */
public class QuickSortTest {

    /**
     * 随机选择一个数pivot，是的pivot的左边的数都比pivot小，右边的都比pivot的大
     * 将除pivot外的数分为两组，pivot则在其本该在的位置
     * 然后对两边的数组递归调用上述逻辑
     * <p>
     * 循环不变量:
     * pivot = nums[left];
     * i用于遍历
     * j是蓝色部分和黄色部分的分界线
     * [left +1,j]<pivot
     * (j,i)>pivot
     *
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums) {
        if (nums == null) {
            return null;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex - 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left+1;
        //all nums in [left+1,j)<=pivot
        //all nums in [j,i)>pivot
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, j, i);
                j++;
            }
        }
        swap(nums,left,j-1);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
