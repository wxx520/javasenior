package com.wxx.java.datastructure.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wxxstar
 * @create 2023-08-14 11:25
 */
public class MaxQueue {

    private Deque<Integer> a, b;

    public MaxQueue() {
        a = new ArrayDeque<>();
        b = new ArrayDeque<>();
    }

    public int max_value() {
        if (b.isEmpty()) {
            return -1;
        }
        return b.peekFirst();
    }

    public void push_back(int value) {
        a.offer(value);
        while (!b.isEmpty() && b.peekLast() < value) {
            b.pollLast();
        }
        b.offerLast(value);
    }

    public int pop_front() {
        if (a.isEmpty()) {
            return -1;
        }
        int v = a.pollFirst();
        if (!b.isEmpty() && v == b.peekFirst()) {
            b.pollFirst();
        }
        return v;
    }
}
