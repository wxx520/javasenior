package com.wxx.java.sort;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * @author lhbac
 * @create 2023/5/31 15:50
 */
public class MergeTwoOrderArraysTest {
    /**
     * 合并两个有序数组，两个数组从头开始遍历，遍历量为i(0<=i<=m-1)、j(0<=j<=n-1)以及结果数组的遍历量为k(0<=k<=m+n-1)
     * 若i>m-1,则nums1[k] = nums[j],j++
     * 若j>n-1,则nums1[k] = nums[i],i++
     * 若 nums1[i]<=num[j],则nums1[k] = nums[i],i++
     * 若 nums1[i]>num[j],则nums1[k] = nums[j],j++
     * 直至k>m+n-1;
     * <p>
     * 此处需要保存nums1的初始值，因为循环时直接在nums上做修改
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        // 只需要把 nums1 的有效个元素复制到 nums3 就可以了
        System.arraycopy(nums1, 0, nums3, 0, m);
        // 数组3
        int i = 0;
        // 数组2
        int j = 0;
        int length = m + n;
        for (int k = 0; k < length; k++) {
            if (i > m - 1) {
                nums1[k] = nums2[j];
                j++;
            } else if (j > n - 1) {
                nums1[k] = nums3[i];
                i++;
            } else if (nums3[i] <= nums2[j]) {
                nums1[k] = nums3[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }
}
