package com.wxx.java.dp;

import org.junit.Test;

/**
 * @author wxxstar
 * @create 2023-04-21 0:28
 */
public class LongestIncreasingSubsequenceTest {

    /**
     * 暴力算法也是动态规划:
     * <p>
     * 1、定义状态也是分析子问题：
     * dp[i]为考虑前i个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i]必须被选取。
     * <p>
     * 2、 我们从小到大计算 dp数组的值，在计算 dp[i]之前，我们已经计算出 dp[0…i−1]的值，
     * 则状态转移方程为：
     * <p>
     * d[i] = max(dp[j])+1, 其中0<=j<i,num[i]>num[j];
     * <p>
     * 3、 然后整个数组的最大上升子序列为最大dp[i],即
     * LISlength = max(d[i]);
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * <p>
     * <p>
     * 【为什么类似的思路，从头开始，选取一个元素作为 *固定开始元素* 则很难建立状态转移方程呢？】
     * 因为只知道开始并不能确定 以该元素为开始的的 最长上升子序列是多长，但是结束可以
     *
     * @param nums
     * @return
     */
    public int maxLISByDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    /**
     * 贪心算法加二分查找
     * <p>
     * 贪心策略
     * 我们想最长上升子序列尽可能长，则要上升的尽可能慢，即序列最后加上的最大值尽可能小。
     * 基于以上贪心策略，我们可以维护一个数组
     * 最大上升序列长度为i的末尾元素的最小值为d[i],用len记录当前的最长上升子序列的长度，起始时，len=1
     * d[1] = nums[0];
     * <p>
     * 证明d[i]随着i/len 单调递增，反证法
     * 假设存在d[i]<=d[j],且i>j，则对于d[i]的最长子序列，减掉数量(i-j)个数，
     * 则重新得到长度为j的最长子序列d1[j],且d1[j]<d[i]<=d[j], 则d1[j]<d[j]。
     * 那么我们就找到了一个长度为 j的最长上升子序列，并且末尾元素比 d[j] 小，从而产生了矛盾。
     * 因此数组 d 的单调性得证。
     * <p>
     *
     * 如何向d[n]中填值
     * 二分策略
     *
     * @param nums
     * @return
     */
    public int maxLISByGreedy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] d = new int[nums.length + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {//向后遍历，发现比最长的最大值大，则增加长度，即len++
                d[++len] = nums[i];
            }else {//否则len向前遍历，找到第一个比nums[i]值大的d[j](1<=j<len)，则 此时d[j]与nums[i]组成一个长度为j+1的最长子序列且该子序列的最后一个值为nums[i]，即d[j+1]=nums[i]；否则即表示d[len]中所有的值都比nums[i]大，则更新d[1] = nums[i];
                boolean isMin = true;
                for (int j = len-1; j >0; j--) {
                    if(nums[i] > d[j]){
                        d[j+1] = nums[i];
                        isMin = false;
                        break;
                    }
                }
                if(isMin){
                    d[1] = nums[i];
                }
            }

        }
        return len;
    }

    public int maxLISByGreedyAndBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] d = new int[nums.length + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {//向后遍历，发现比最长的最大值大，则增加长度，即len++
                d[++len] = nums[i];
            }else {//否则len向前遍历，更新长度较小长度以及长度不变时更新序列的最后一个最大值
                boolean isMin = true;
                for (int j = len-1; j >0; j--) {
                    if(nums[i] > d[j]){
                        d[j+1] = nums[i];
                        isMin = false;
                        break;
                    }
                }
                if(isMin){
                    d[1] = nums[i];
                }
            }

        }
        return len;
    }

    @Test
    public void t1() {
        System.out.println(maxLISByDP(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
