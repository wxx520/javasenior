package com.wxx.java.datastructure.stack;

import java.util.Stack;

/**
 * @author wxxstar
 * @create 2023-07-25 21:21
 */
public class LinkedListStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }
}
