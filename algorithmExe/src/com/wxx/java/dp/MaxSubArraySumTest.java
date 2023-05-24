package com.wxx.java.dp;

/**
 * @author wxxstar
 * @create 2023-05-14 16:37
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaxSubArraySumTest {

    /**
     * 暴力算法:
     * 从第一个元素开始遍历：
     * 从首元素到最后一个元素做区间求和，求遍历开始的元素和后面元素最大的区间和
     * 时间复杂度：
     * 空间复杂度：O(n^2)
     * 时间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayByBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numsLength = nums.length;
        int maxSum = nums[0];
        for (int i = 0; i < numsLength; i++) {
            int tempMaxSum = nums[i];
            int tempSum = nums[i];
            for (int j = i + 1; j < numsLength; j++) {
                tempSum = tempSum + nums[j];//从头遍历到最后一个元素求区间和
                tempMaxSum = Math.max(tempSum, tempMaxSum);//获取固定首元素的最大区间和
            }
            maxSum = Math.max(tempMaxSum, maxSum);//获取不同首元素的最大区间和
        }
        return maxSum;
    }

    /**
     * 滑动窗口: 区间起始点
     * 空间复杂度：O(n)
     * 时间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayBySlidingWindow(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int slidingWindowSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            maxSum = Math.max(maxSum,currentNum);
            if(slidingWindowSum<=0){
                slidingWindowSum = currentNum;
                continue;
            }
            slidingWindowSum = slidingWindowSum + currentNum;
            maxSum = Math.max(maxSum,slidingWindowSum);
        }
        return maxSum;
    }


    /**
     * 动态规划
     * 空间复杂度：O(n)
     * 时间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayByDP(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayByDP(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArrayByDP(new int[]{1}));
        System.out.println(maxSubArrayByDP(new int[]{5, 4, -1, 7, -9, 8}));
    }
}
