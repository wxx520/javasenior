package com.wxx.java.backtrace;

import org.junit.Test;

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

        dfs(nums, 0, new ArrayDeque<>(), used, ret);

        return ret;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> ret) {
        if (depth == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.offerLast(nums[i]);
            used[i] = true;

            System.out.println("  递归之前 => " + path);
            dfs(nums, depth + 1, path, used, ret);
            System.out.println("递归之后 => " + path);

            used[i] = false;
            path.pollLast();
            System.out.println("递归之后回溯还原 => " + path);
        }

    }

    @Test
    public void t1(){
        int[] arr = {1,2,3};
        List<List<Integer>> ret = permute(arr);
        System.out.println(ret);
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
