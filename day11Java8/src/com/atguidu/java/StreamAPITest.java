package com.atguidu.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wxxstar
 * @create 2023-04-02 22:08
 */
public class StreamAPITest {

    @Test
    public void t1() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void middleOperateTest() {
        List<String> list = Arrays.asList("aa","cc","xx","dd","bb");
        List<String> list1 = Arrays.asList();
        list.stream().map(String::toUpperCase).forEach(e -> {

            System.out.println(e);
        });

        list1 = list.stream().map(String::toUpperCase).toList();
        System.out.println(list1);
        System.out.println("******************");
        list.stream().sorted((e1,e2)->{
            System.out.println(e1+" : "+e2);
            return e1.compareTo(e2);
        }).forEach(System.out::print);
        System.out.println("******************方法");
        list.stream().sorted(String::compareTo).forEach(System.out::print);

    }
}
