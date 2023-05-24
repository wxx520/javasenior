package com.atguigu.java;

import org.junit.Test;

/**
 * @author wxxstar
 * @create 2023-02-27 20:33
 */
public class DateTimeTest {
    @Test
    public void SystemTest() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1号0点0分0秒的毫秒查
    }

    /**
     * java.util.Date类
     * |---java.sql.Date类
     * 1、两个构造器的使用
     * 2、两个方法的使用
     * >toString: 显示当前的年、月、日、时、分、秒
     * >getTime：获取当前Date对象的毫秒数。(时间戳)
     */
    @Test
    public void DateTest() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1号0点0分0秒的毫秒查
    }

    /**
     * 获取subStr在mainStr中出现的次数
     *
     * @param mainStr
     * @param subStr
     * @return
     */
    public static int getCount(String mainStr, String subStr) {
        if (mainStr == null || subStr == null) {
            return 0;
        }
        int mainLen = mainStr.length(), sunLen = subStr.length();
        if (mainLen < sunLen) {
            return 0;
        }
        int count = 0, index = 0;
        /*while ((index=mainStr.indexOf(subStr))!=-1){
            count++;
            mainStr = mainStr.substring(index+subStr.length());
        }*/
        while ((index = mainStr.indexOf(subStr, index)) != -1) {
            count++;
            index += sunLen;
        }

        return count;

    }

    /**
     * 获取两个字符串中最大相同子串。比如：
     * str1 = "abcwerthelloyuiodefabcdef";str2="cvhellobnm";
     *
     * @param str1
     * @param str2
     */
    public static String getMaxSameString(String str1, String str2) {
        if(str1==null||str2==null){
            return null;
        }
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int length = minStr.length();
        for (int i = 0; i < length; i++) {
            for (int x = 0,y=length-i;y<=length;x++,y++) {
                String subStr = minStr.substring(x,y);
                if(maxStr.contains(subStr)){
                    return subStr;
                }
            }
        }
        return null;
    }

    @Test
    public void StringFindTest() {
        int count = getCount("abkkkkabaammmabkkkllablllab", "ab");
        System.out.println(count);
        String str1 = "abcwerthelloyuiodefabcdef",str2="cvhellobnm";
        String sameStr = getMaxSameString(str1,str2);
        System.out.println(sameStr);
    }

    @Test
    public void StringBufferTest() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
