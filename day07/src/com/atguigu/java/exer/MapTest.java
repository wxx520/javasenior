package com.atguigu.java.exer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author wxxstar
 * @create 2023-03-02 22:12
 */
public class MapTest {

    @Test
    public void test(){
        Map map = new HashMap();
        map.put(null,null);
        System.out.println(map);
        map = new Hashtable();
        map.put(null,null);
        System.out.println(map);
    }
}
