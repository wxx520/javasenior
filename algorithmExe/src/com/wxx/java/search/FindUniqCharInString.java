package com.wxx.java.search;

/**
 * @author wxxstar
 * @create 2023-08-07 8:41
 * <p>
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5viisg/
 */
public class FindUniqCharInString {


    public static char firstUniqCharByBF(String s) {
        int sLen = s.length();

        if (sLen == 0) {
            return ' ';
        }

        if (sLen == 1) {
            return s.charAt(0);
        }


        int offset = 96;

        //索引为char-97,值为该char的总数
        int[] charCount = new int[27];
        //索引为char的序号,值为该char最小的序号
        int[] charIndex = new int[27];
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            int index = c - offset;
            charCount[index] = charCount[index] + 1;
            if (charIndex[index] == 0) {
                charIndex[index] = i + 1;
            }
        }
        char noRepeat = ' ';
        int minIndex = sLen + 1;
        for (int i = 1; i < 27; i++) {
            if (charCount[i] == 0 || charCount[i] > 1) {
                continue;
            }
            if (charIndex[i] < minIndex) {
                minIndex = charIndex[i];
                noRepeat = (char) (i + 96);
            }

        }
        return noRepeat;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqCharByBF("dddccdbba"));
    }
}
