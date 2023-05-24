package com.java.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author wxxstar
 * @create 2023-03-24 17:49
 */
public class FileIOStreamTest {
    @Test
    public void testFileExist() {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsoluteFile());

        File file1 = new File("day08\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /**
     * 将day08下的hello.txt文件内容读入程序中，并输出到控制台
     */
    @Test
    public void testFileReader() throws IOException {
        //1. 实例化File类的对象，指明要操作的文件
        File file = new File("hello.txt");//相较于当前工程


        //2. 提供具体的流
        FileReader fr = new FileReader(file);

        //3. 数据的读入
        int data = fr.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fr.read();
        }

        /*int data1;
        while ((data1=fr.read())!=-1){
            System.out.println(data1);
        }*/

        //4. 流的关闭操作
        fr.close();
    }

    /**
     * 对read()操作升级：使用read的重载方法
     */
    @Test
    public void testFileReader1() {
        //1. File类的实例化
        File file = new File("hello.txt");
        //2. FileReader流类的实例化;
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] cbuffer = new char[5];
            int len;
            while ((len = fr.read(cbuffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuffer[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //3. 读入的操作

        //4. 资源的关闭

    }

    @Test
    public void testFileWriter() throws IOException {
        //1. 提供File的对象，指明写出到的文件
        File file = new File("hello1.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("I have a dream!\n");
        fw.write("You need to have a dream!");
        fw.close();

    }

    @Test
    public void testFileReaderFileWriter() throws IOException {
        //1. 创建File类的对象，指明读入和写入文件
        File file1 = new File("hello.txt");
        File file2 = new File("hello2.txt");


        //2. 创建输入和输出流的对象

        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);

        //3. 数据的读取和写入
        char[] cbufs = new char[5];
        int len;
        while ((len = fr.read(cbufs)) != -1) {
            fw.write(cbufs, 0, len);
        }
        fw.close();
        fr.close();
        //4. 关闭流资源
    }

    @Test
    public void testFileInput() throws IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[5];
        int len;
        while ((len=fis.read(buffer))!=-1){
            String str = new String(buffer,0,len);
            System.out.print(str);
        }
        fis.close();

    }
}
