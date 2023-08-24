package com.wxx.java.datastructure.list;

import org.junit.Test;

/**
 * @author lhbac
 * @create 2023/8/22 16:27
 */
public class ListRotateRightTest {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode lastNode = null;
        int count = 0;
        while (cur != null) {
            count++;
            if (cur.next == null) {
                lastNode = cur;
            }
            cur = cur.next;
        }

        int remain = k % count;
        if (remain == 0) {
            return head;
        }

        remain = count - remain;

        lastNode.next = head;
        cur = head;
        while (remain > 1) {
            remain--;
            cur = cur.next;
        }

        ListNode ret = cur.next;
        cur.next = null;
        return ret;
    }

    @Test
    public void t1() {
        System.out.println(rotateRight(ListNode.convert(new int[]{1, 2, 3, 4, 5}), 2));
    }
}
