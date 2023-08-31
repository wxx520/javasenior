package com.wxx.java.backtrace;

import org.junit.Test;

import java.util.*;

/**
 * @author lhbac
 * @create 2023/8/30 21:18
 * <p>
 * https://leetcode.cn/problems/generate-parentheses/?envType=study-plan-v2&envId=top-interview-150
 */
public class GenerateParenthesisTest {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    @Test
    public void t1() {
        long ct = System.currentTimeMillis();
        System.out.println(generateParenthesis(1));
        System.out.println(System.currentTimeMillis() - ct);
    }
}
