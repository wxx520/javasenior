package com.atguidu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表示的使用
 *
 * @author wxxstar
 * @create 2023-04-02 17:46
 */
public class LambdaTest1 {
    /**
     * 语法格式一：无参，无返回值
     */
    @Test
    public void t1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        System.out.println("******************************");
        Runnable r2 = () -> System.out.println("我爱北京故宫");

        r2.run();
    }

    /**
     * 语法格式二：需要一个参数，无返回值
     */
    @Test
    public void t2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("***********");
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真了，一个是说的人当真了");
    }

    /**
     * 语法格式三：数据类型可以省略，因为可有编译器推断得出，称为“类型推断”
     */
    @Test
    public void t3() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("***********");
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真了，一个是说的人当真了");

    }

    /**
     * 语法格式四：无参，无返回值
     */
    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<>();//类型推断
    }

    /**
     * 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void t4() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("***********");
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真了，一个是说的人当真了");

    }

    /**
     * 语法格式六：当Lambda 体只有一条语句时，return与大括号若有，都可以省略；
     */
    @Test
    public void t6() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        int compare2 = com2.compare(12, 21);
        System.out.println(compare2);
    }

    /**
     * 语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void t5() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };

        int compare2 = com2.compare(12, 21);
        System.out.println(compare2);

    }
}
