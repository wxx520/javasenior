package com.atguigu.java.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author wxxstar
 * @create 2023-02-28 19:27
 * 遍历
 */
public class IteratorTest {

    @Test
    public void test(){
        Collection collection = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 测试iterator中remove方法
     */
    @Test
    public void testRemove(){
        Collection collection = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
