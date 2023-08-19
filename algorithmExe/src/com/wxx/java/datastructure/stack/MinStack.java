package com.wxx.java.datastructure.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wxxstar
 * @create 2023-08-13 9:41
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/50bp33/
 */
public class MinStack {

    private Stack<Integer> a, b;

    public MinStack() {
        a = new Stack();
        b = new Stack();
    }

    public void push(int val) {
        a.push(val);
        if (b.isEmpty() || val <= b.peek()) {
            b.push(val);
        }
    }

    public void pop() {
        int n = a.pop();
        if (n == b.peek()) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }

    @Test
    public void t1(){
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
