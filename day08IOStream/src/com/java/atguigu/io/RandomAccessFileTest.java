package com.java.atguigu.io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @author wxxstar
 * @create 2023-03-25 16:59
 */
public class RandomAccessFileTest {

    @Test
    public void t1() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(""),"rw");
    }
}
