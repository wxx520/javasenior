package com.atguigu.java.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author wxxstar
 * @create 2023-03-01 18:24
 */
public class TreeSetTest {

    @Test
    public void treeSetTest() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(12);
        treeSet.add(32);
        treeSet.add(-12);
        System.out.println(treeSet);
    }

    @Test
    public void treeSetTest1() {
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        };

        TreeSet treeSet = new TreeSet(comparator);
        treeSet.add(new User("Tom",12));
        treeSet.add(new User("Jerry",32));
        treeSet.add(new User("Jim",2));
        treeSet.add(new User("Mike",65));
        treeSet.add(new User("Jack",33));
        treeSet.add(new User("Mery",33));
        System.out.println(treeSet);
    }

    @Test
    public void treeSetTest2() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new User("Tom",12));
        treeSet.add(new User("Jerry",32));
        treeSet.add(new User("Jim",2));
        treeSet.add(new User("Mike",65));
        treeSet.add(new User("Jack",33));
        System.out.println(treeSet);
    }
}

class User implements Comparable{


    private String name;
    private int age;
    public String getName() {
        return name;
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //按照姓名有小到大排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
            int compare = this.name.compareTo(user.name);
            return this.name.compareTo(user.name);
        }

        return 0;
    }
}