package com.wxx.java.datastructure.list;

import org.junit.Test;

/**
 * @author lhbac
 * @create 2023/8/22 20:57
 */
public class RemoveNodeByX {
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyCur = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                continue;
            }
            ListNode remain = cur.next;

            cur.next = null;
            dummyCur.next = cur;
            dummyCur = dummyCur.next;

            cur = remain;
        }
        return dummyNode.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }

        }
        return head;
    }

    @Test
    public void t1() {
        System.out.println(removeElements(ListNode.convert(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
        System.out.println(removeElements(ListNode.convert(new int[]{1, 2}), 1));
        System.out.println(removeElements(ListNode.convert(new int[]{7, 7, 7, 7}), 7));
    }
}
