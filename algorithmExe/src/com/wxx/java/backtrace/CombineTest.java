package com.wxx.java.backtrace;

import org.junit.Test;

import java.util.*;

/**
 * @author lhbac
 * @create 2023/8/28 10:10
 * 组合
 * https://leetcode.cn/problems/combinations/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 */
public class CombineTest {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ret = new ArrayList<>();
        if (n == 1 || k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                ret.add(list);
            }
            return ret;
        }
        dfs(n, k, 0, new ArrayList<>(), ret);
        return ret;
    }

    /**
     * 定义该函数，
     *
     * @param n  带选择的数组
     * @param k     从该数组中选出k个数
     * @param depth 已经选择的个数
     * @param path  将选出的数放入path中
     * @param ret   放所有的结果
     */
    private void dfs(int n, int k, int depth, List<Integer> path, List<List<Integer>> ret) {
        if (k == depth) {
            List<Integer> cList = new ArrayList<>(path);
            ret.add(cList);
            return;
        }

        for (int i = depth; i < n; i++) {

            int num = i+1;
            if (depth > 0 && path.get(depth - 1) >= num) {
                continue;
            }

            path.add(num);

            dfs(n, k, depth + 1, path, ret);

            path.remove(path.size()-1);
        }
    }

    @Test
    public void t1() {
        System.out.println(combine(4, 2));
    }
}
