package com.wxx.java.sort;

/**
 * @author lhbac
 * @create 2023/5/24 15:13
 * <p>
 * 选择排序
 */
public class SelectionSortTest {
    /**
     * 选择排序
     * 「选择排序 Insertion Sort」的工作原理非常直接：开启一个循环，每轮从未排序区间选择最小的元素，将其放到已排序区间的末尾。完整步骤如下：
     *
     * 1、初始状态下，所有元素未排序，即未排序（索引）区间为
     * 2、选取区间[0,n-1]中的最小元素，将其与索引0处元素交换。完成后，数组前 1 个元素已排序。
     * 3、选取区间[1,n-1]中的最小元素，将其与索引1处元素交换。完成后，数组前 2 个元素已排序。
     * 4、以此类推。经过n-1轮选择与交换后，数组前个元素已排序。
     * 5、仅剩的一个元素必定是最大元素，无需排序，因此数组排序完成。
     *
     * 此时循环不变量为[0,i)为有小到大排列完成的数0<=i<n
     *
     * @param nums
     */
    void selectionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            int k = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    k = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }
}
