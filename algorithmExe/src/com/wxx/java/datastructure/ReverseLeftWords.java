package com.wxx.java.datastructure;

import org.junit.Test;

/**
 * @author wxxstar
 * @create 2023-08-13 11:24
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() <= 1 || n >= s.length()) {
            return s;
        }
        int len = s.length();
        String subStr = s.substring(n, len);
        String subStr1 = s.substring(0, n);
        return subStr + subStr1;
    }

    @Test
    public void t1() {
        String s = "abcdefg";
        System.out.println(s.substring(2, s.length()));
        System.out.println(s.substring(0, 2));
    }
}
