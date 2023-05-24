package com.atguigu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author wxxstar
 * @create 2023-03-26 16:36
 */
public class ClassLoaderTest {
    @Test
    public void t1(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader cl1 = classLoader.getParent();

        System.out.println(cl1);

        //调用扩展类加载器的getParent()：无法获取引导类的加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的
        ClassLoader cl2 = cl1.getParent();

        System.out.println(cl2);
    }

    @Test
    public void t2() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        properties.load(fis);
        String user = properties.getProperty("name");
        String pd = properties.getProperty("password");
        System.out.println("user: "+user+", password: "+pd);
    }
}
