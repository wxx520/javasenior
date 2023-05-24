package com.atguigu.java.exer;

import org.junit.Test;

import java.util.*;

/**
 * @author wxxstar
 * @create 2023-03-02 21:24
 */
public class TreeSetTest {

    /**
     * 自然排序
     */
    @Test
    public void test1() {
        TreeSet set = new TreeSet();
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));

        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        ;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    /**
     * 定制排序排序
     */
    @Test
    public void test2() {
        TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                int yr = Integer.compare(b1.getYear(), b2.getYear());
                if (yr != 0) {
                    return yr;
                }
                int mr = Integer.compare(b1.getMonth(), b2.getMonth());
                if (mr != 0) {
                    return mr;
                }

                return Integer.compare(b1.getDay(), b2.getDay());
            }
        }
        );

        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));

        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        ;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 定制排序排序
     */
    @Test
    public void test3() {
        HashSet<Person> set= new HashSet<>();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.setName("CC");
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);


    }
}
