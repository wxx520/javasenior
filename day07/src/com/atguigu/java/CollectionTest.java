package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wxxstar
 * @create 2023-03-02 14:14
 */
public class CollectionTest {

    @Test
    public void t1(){
        Collection coll =  new ArrayList();
        coll.add(123);
        coll.add(234);
        coll.add(333);
        coll.forEach(System.out::println);
    }
}
