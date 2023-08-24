package com.wxx.java.backtrace;

import java.util.ArrayList;
import java.util.List;

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
        
        dfs(nums, len, 0, new ArrayList<>(), used, ret);

        return ret;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

    }
}
