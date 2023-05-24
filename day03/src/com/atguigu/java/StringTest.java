package com.atguigu.java;

import org.junit.Test;

/**
 * @author wxxstar
 * @create 2023-02-26 21:49
 * @see  java.lang.String
 */
public class StringTest {
    /**
     * java.lang.String:public final class String
     * 1、String声明为final的，不可被继承
     * 2、String实现了Serializable接口：表示字符串是支持序列化
     * 3、      实现了Comparable接口：表示String可以比较大小
     * 3、String内部定义了final char[] value用于存储字符串数据
     * 4、代表不可变的字符序列。简称：不可变性
     * 5、通过 字面量 的方式给一个字符串赋值，此时的字符串声明在字符串常量池中。
     * 6、字符串常量池中是不会存储相同内容的字符串
     */


    /**
     * 1、常量与常量的拼接还是常量
     * 2、拼接操作时只要有一个是变量，返回结果就在堆空间中
     * 3、拼接的结果调用.intern()则返回的是方法区的不可变字符数组的首地址

     * */
    @Test
    public void test() {
        String a = "abc";
        String b = "abc";
        String a1 = new String(a);
        String a2 = new String(a);
        String aSub ="a";
        String aSub1="bc";

        System.out.println(a==a1);
        System.out.println(b==a);
        System.out.println(a1==a2);
        System.out.println(a1);
        System.out.println(a==("a"+"bc"));

        System.out.println(a==(aSub+aSub1));
        System.out.println(a==(aSub+aSub1).intern());
        String s1 = "hellorworld";
        boolean b1 = s1.endsWith("World");
        System.out.println(s1.lastIndexOf("or"));
        System.out.println(s1.indexOf("or"));
    }

    /**
     *StringBuffer:
     * 增：append
     * 删：delete
     * 改：setCharAt、insert
     * 查:charAt、
     * 遍历
     */
    @Test
    public void test1() {
        StringBuffer sb1= new StringBuffer();
        System.out.println(sb1.length());
        char[] c1= new char[5];
        System.out.println(c1.length);
    }

    @Test
    public void test2(){

    }

}
