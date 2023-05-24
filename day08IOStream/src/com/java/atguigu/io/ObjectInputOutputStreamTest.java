package com.java.atguigu.io;

import org.junit.Test;

import java.io.*;

/**
 * @author wxxstar
 * @create 2023-03-25 15:30
 */
public class ObjectInputOutputStreamTest {
    /**
     * 序列化过程：将内存中的java对象保存到磁盘或通过网络传输出去；
     * 使用ObjectOutputStream实习
     */
    @Test
    public void testObjectOutputStream() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
        oos.writeObject(new String("我爱北京天安门"));
        oos.flush();//刷新对象
        oos.close();
    }

    /**
     * 反序列化：将磁盘文件中的对象还原为内存中的一个java对象
     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }


    }
}
