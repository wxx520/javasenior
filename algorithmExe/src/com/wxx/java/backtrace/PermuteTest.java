package com.wxx.java.backtrace;

import java.util.*;

/**
 * @author lhbac
 * @create 2023/8/23 15:54
 */
public class PermuteTest {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;

        List<List<Integer>> ret = new ArrayList<>();

        boolean[] used = new boolean[len];

        dfs(nums, len, 0, new ArrayDeque<>(), used, ret);

        return ret;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> ret) {
        if (depth == len) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                return;
            }
            path.offerLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, ret);
            used[i] = false;
            path.pollLast();
        }

    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
