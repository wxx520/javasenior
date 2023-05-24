package com.atguigu.java.collection.exe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxxstar
 * @create 2023-03-01 17:37
 */
public class ListExer {
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
