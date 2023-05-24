package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wxxstar
 * @create 2023-03-26 14:52
 */
public class ReflectionTest {

    /**
     * 反射之前对Person的操作
     */
    @Test
    public void t1() {
        //1. 创建Person类的对象
        Person p1 = new Person("Tom", 12);
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();

    }

    /**
     * 反射之后，对Person的操作
     */
    @Test
    public void t2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obk = constructor.newInstance("Tom", 12);
        Person person = (Person) obk;
        System.out.println(person.toString());

        Field age = clazz.getDeclaredField("age");
        age.set(person,10);

        System.out.println(person.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        System.out.println("*************************");

        //通过反射：可以调用Person类的私有结构。比如：私有的构造器、方法、属性。
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p1 = (Person) constructor1.newInstance("Jerry");
        System.out.println(p1);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"hanMeiMei");
        System.out.println(p1);

        Method showNation = clazz.getDeclaredMethod("showNation",String.class
        );
        showNation.setAccessible(true);
        String nation = (String)showNation.invoke(p1,"中国");
        System.out.println(nation);

    }
}
