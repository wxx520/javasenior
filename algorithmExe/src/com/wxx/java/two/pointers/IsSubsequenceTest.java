package com.wxx.java.two.pointers;

/**
 * @author wxxstar
 * @create 2023-09-02 13:32
 */
public class IsSubsequenceTest {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int slen = s.length();
        int tlen = t.length();
        if (slen > tlen) {
            return false;
        }
        if (slen == 0 || s.equals(t)) {
            return true;
        }
        int index = 0;
        int i = 0;
        while (index < slen && i < tlen) {
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
            i++;

        }
        return index == slen;
    }

}
