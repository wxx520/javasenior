package com.wxx.java.two.pointers;

import org.junit.Test;

/**
 * @author wxxstar
 * @create 2023-09-02 11:03
 * https://leetcode.cn/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class IsPalindromeTest {

    public boolean isPalindrome(String s) {

        if (s == null || s.isBlank()) {
            return true;
        }

        int len = s.length();
        int start = 0;
        int end = len - 1;
        while (start < len - 1 || end > 0) {
            while (start < len && isNotLetter(s.charAt(start))) {
                start++;
                if (start == len) {
                    break;
                }
            }

            while (end >= 0 && isNotLetter(s.charAt(end))) {
                end--;
                if (end < 0) {
                    break;
                }
            }
            if (start >= len && end < 0) {
                return true;
            }

            if (start >= len || end < 0) {
                return false;
            }

            char cs = s.charAt(start);
            char ce = s.charAt(end);

            start++;
            end--;

            if (cs == ce || ((cs >= 'A' && (ce >= 'A')) && ((cs - ce) == 32 || (cs - ce) == -32))) {
                continue;
            }

            return false;

        }

        return true;

    }

    private boolean isNotLetter(char c) {
        return (c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z');
    }

    @Test
    public void t1() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome(".,"));
    }
}
