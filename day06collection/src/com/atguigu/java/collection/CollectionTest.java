package com.atguigu.java.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wxxstar
 * @create 2023-02-28 19:07
 */
public class CollectionTest {

    /**
     * 向collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
     */
    @Test
    public void test() {
        Collection collection = new ArrayList();
        collection.contains(123);
    }
}
