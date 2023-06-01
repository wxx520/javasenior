package com.wxx.java.sort;

import org.junit.Test;

/**
 * @author lhbac
 * @create 2023/5/31 16:13
 */
public class ReversePairsTest {

    /**
     * 暴力算法
     * 对于数组中的元素来说num[i]而言，只有[0..i)及其之前的数才有可能成为逆序对
     * 从尾部到头遍历，若发现比num[i]大则为逆序对，直至遍历到倒数第二个元素
     *
     * @param nums
     * @return
     */
    public int reversePairs0(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int res = 0;
        for (int i = len - 1; i > 0; i--) {
            int base = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > base) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 分而治之：拆分问题
     * 先拆分，直至只有一个元素
     * 然后合并算逆序对，结果是所有逆序对之和
     * <p>
     * https://www.suanfa8.com/merge-sort/solutions/0051-shu-zu-zhong-de-ni-xu-dui-lcof
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int[] temp = new int[len];
        return reversePairs(nums, 0, len - 1, temp);
    }

    private int insertionSort1(int[] nums, int left, int right) {
        int count = 0;
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j;
            for (j = i; j > left && nums[j - 1] > temp; j--) {
                nums[j] = nums[j - 1];
                count++;
            }
            nums[j] = temp;
        }
        return count;
    }

    private int insertionSort(int[] nums, int left, int right) {
        int count = 0;
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j;//j即为待插入元素的下标
            for (j = i; j > left && nums[j - 1] > temp; j--) {
                nums[j] = nums[j - 1];//比插入的数大的都要往后移动一位
                count++;
            }
            nums[j] = temp;//空出来的位置即为待插入元素的位置
        }
        return count;
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (right - left < 16) {
            return insertionSort(nums, left, right);
        }
        int mid = left + (right - left) / 2;//向下取整
        //分组
        int leftCount = reversePairs(nums, left, mid, temp);
        int rightCount = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {//所以mid+1不会越界
            return leftCount + rightCount;
        }
        int mergeCount = mergeAndCount(nums, left, mid, right, temp);
        //对分组元素进行合并排序，并计算
        return (leftCount + rightCount + mergeCount);
    }

    public int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int res = 0;
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
                res = res + (mid - i) + 1;
            }
        }
        return res;
    }

    @Test
    public void t1() {
        int[] arr = {7, 5, 6, 4};
        System.out.println(reversePairs(arr));
        ;
    }
}
