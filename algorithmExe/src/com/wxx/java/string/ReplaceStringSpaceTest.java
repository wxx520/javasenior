package com.wxx.java.string;

import org.junit.Test;

public class ReplaceStringSpaceTest {
    public String replaceSpaceByAPI(String s) {
        if (s==null||s.isEmpty()){
            return s;
        }
        return s.replace(" ","%20");
    }

    /**
     * 遍历输入字符串s，做字符对比，如果当前字符是空格，则用目标字符匹配
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if (s==null||s.isEmpty()){
            return s;
        }
        int length = s.length();
        char[] newStrChars = new char[length*3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c==' '){
                newStrChars[size++]='%';
                newStrChars[size++]='2';
                newStrChars[size++]='0';
            }else {
                newStrChars[size++]=c;
            }
        }
        String newStr = new String(newStrChars,0,size);
        return newStr;
    }

    @Test
    public void t1(){
        System.out.println(replaceSpace("We are happy."));
    }
}
