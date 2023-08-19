package com.wxx.java.datastructure;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wxxstar
 * @create 2023-08-12 20:08
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/5d3i87/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5d3i87/
 */
public class CQueueStackTest {

    private Stack<Integer> head, tail;

    private int count = 0;

    public CQueueStackTest() {
        head = new Stack<>();
        tail = new Stack<>();
    }

    public void appendTail(int value) {
        count++;
        tail.push(value);
    }

    public int deleteHead() {
        if (count > 0) {
            count--;
            if (!head.isEmpty()) {
                return head.pop();
            }
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
            return head.pop();
        } else {
            return -1;
        }
    }

    @Test
    public void t1() {
        CQueueStackTest test = new CQueueStackTest();
        System.out.println(test.deleteHead());
        test.appendTail(5);

        test.appendTail(3);
        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
    }
}
