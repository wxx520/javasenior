package com.atguigu.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wxxstar
 * @create 2023-02-27 23:49
 */
public class CompareTest {
    /**
     * 自然排序
     */
    @Test
    public void comparableTest() {
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD","SS","LL"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 定制排序
     */
    @Test
    public void comparatorTest() {

    }
}
