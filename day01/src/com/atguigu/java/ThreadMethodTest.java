package com.atguigu.java;

/**
 * 1.测试Thread中的常用方法
 * 1.start():启动当前线程；调用当前线程run()
 * 2.run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName()
 * 5.setName(String)
 * 6.yield():释放当前cup的执行权
 * 7.join():在线程a中调用线程b的join,此时
 * 8.static sleep(long milliTime)：让当前线程睡眠指定的毫秒数，在指定毫秒时间内，当前线程为阻塞状态
 * 9.stop:已过时，当执行此方法时，强制结束当前线程。
 * @author wxxstar
 * @create 2023-02-25 16:55
 */
public class ThreadMethodTest {
}
