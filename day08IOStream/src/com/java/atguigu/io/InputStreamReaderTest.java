package com.java.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author wxxstar
 * @create 2023-03-24 22:12
 */
public class InputStreamReaderTest {
    @Test
    public void t1() throws Exception {
        FileInputStream fis = new FileInputStream("hello.txt");
        //InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        char[] cbuf = new char[20];
        int len;
        while ((len=isr.read(cbuf))!=-1){
            String str = new String(cbuf,0,len);
            System.out.print(str);
        }
        isr.close();

    }

    @Test
    public void t2() throws Exception {
        File file1 = new File("hello.txt");
        File file2 = new File("hello_gbk.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        char[] cbuf = new char[20];
        int len;
        while ((len=isr.read(cbuf))!=-1){
            osw.write(cbuf,0,len);
        }
        isr.close();
        osw.close();

    }
}
