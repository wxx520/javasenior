package com.wxx.java.datastructure.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxxstar
 * @create 2023-04-16 20:39
 *
 * 逻辑，就是遍历所有的情况
 */
public class StringCompareTest {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */

    public static int lengthOfLongestSubString(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.max(left,map.get(c)+1);
            }
            map.put(c,i);
            max = Math.max(max,i-left+1);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubString(s));
        System.out.println(s.substring(1, 3));

    }
}
