package com.atguidu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 * <p>
 * 消费型接口 Consumer<T>
 * 供给型接口 Supplier<T></>
 * 函数型接口 Function<T,R></>
 * 断定型接口 Predicate<T></>
 *
 * @author wxxstar
 * @create 2023-04-02 21:03
 */

class Person {
    private String name;

    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class LambdaFunctionTest {

    @Test
    public void t1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买瓶矿泉水，价格为 ：" + aDouble);
            }
        });

        System.out.println("*****************");

        happyTime(400, money -> System.out.println("学习太累了，去天上人间买瓶矿泉水，价格为 ：" + money));
    }

    private List<Person> genList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Tome", 12));
        list.add(new Person("Luka", 32));
        list.add(new Person("Rita", 23));
        list.add(new Person("Coco", 11));
        return list;
    }

    @Test
    public void streamTest() {
        List<Person> pList = genList();
        System.out.println(pList);
        List<Person> pList1 = pList.stream().map(e -> {
            if (e.getName().contains("a")) {
                e.setAge(100);
            }
            return e;
        }).toList();
        System.out.println("*****************");
        System.out.println(pList);
        System.out.println(pList1);
    }

    @Test
    public void t2() {
        List<String> list = Arrays.asList("背景", "北京", "南京", "田径", "东京");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);

        List<String> filterList = filterString(list, s -> s.contains("京"));
        System.out.println(filterList);

    }

    /**
     * 根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法实现决定
     *
     * @param list
     * @param pre
     * @return
     */
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<String>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }

    private void happyTime(double money, Consumer<Double> com) {
        com.accept(money);
    }

    @Test
    public void test11() {
        Comparator<Object> comparator = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader){
            reader.read();
            reader.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
