package com.wxx.java.sort;

import org.junit.Test;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 * <p>
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * @author lhbac
 * @create 2023/6/1 8:54
 */
public class ImportReversePairsTest {

    /**
     * 暴力算法
     * 对于数组中的元素来说num[i]而言，只有[0..i)及其之前的数才有可能成为逆序对
     * 从尾部到头遍历，若发现nums[j]>2*num[i]则为重要翻转对，直至遍历到倒数第二个元素
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
                if (nums[j] - base > base) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 升序的数组无翻转对
     * 降序的数组有可能有翻转对
     * 对于两个升序的数组，翻转对的数量=leftCount+right+crossCount;
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

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int leftCount = reversePairs(nums, left, mid, temp);
        int rightCount = reversePairs(nums, mid + 1, right, temp);
        /*if (nums[mid] <= nums[mid + 1]) {//[-5,-5]对于负数，则不成立
            return (leftCount + rightCount);
        }*/
        int crossCount = mergeAndCount(nums, left, mid, right, temp);
        return (leftCount + rightCount + crossCount);
    }

    //如果
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int res = 0;
        while (i <= mid && j <= right) {
            if (temp[i] - temp[j] > temp[j]) {
                res += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        i = left;
        j = mid + 1;
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
            } else {//temp[i]>temp[j]
                nums[k] = temp[j];
                j++;

            }
        }
        return res;
    }

    @Test
    public void t1() {
        int[] arr = {-185, 143, -154, -338, -269, 287, 214, 313, 165, -364, -22, -5, 9, -212, 46, 328, -432, -47, 317, 206, -112, -9, -224, -207, 6, 198, 290, 27, 408, 155, 111, -230, -2, -266, 84, -224, -317, 39, -482, 159, 35, 132, -151, 70, -179, 104, -156, 450, -13, 216, 190, 238, -138, 354, 171, -398, -36, 417, 26, -27, -142, 478, -362, -91, -262, -11, 469, 248, -286, -269, -69, -221, -70, 26, 484, -31, -236, -173, -380, -8, 312, -138, -96, 23, -7, 39, -345, 269, 156, 349, 200, 52, 193, 152, 168, 159, 181, 272, -259, 210, 76, 194, -31, 139, 392, -16, -151, 50, 166, 45, 9, 44, -179, 151, -8, 75, -277, -18, 49, 314, -332, 449, 24, 362, 88, 159, 14, -279, 232, 211, -206, -192, 27, 238, -339, -79, 30, -370, -29, 81, 251, -189, 21, -202, -41, 198, 51, -6, 172, 108, 26, -168, 316, 271, -76, -20};
        int[] arr1 = {-5, -5};
        System.out.println(reversePairs(arr1));
    }
}
