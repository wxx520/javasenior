package com.wxx.java.datastructure.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author wxxstar
 * @create 2023-08-12 19:43
 */
public class ListNodeReversePrintTest {

    public int[] reversePrint(ListNode head) {
        Deque<Integer> queue = new ArrayDeque<>();
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            queue.add(temp.val);
            temp = temp.next;
        }
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = queue.pollLast();
        }
        return arr;
    }
}
