package com.wxx.java.datastructure.list;

import org.junit.Test;

/**
 * @author lhbac
 * @create 2023/8/22 16:47
 */
public class DeleteDuplicates {

    /**
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesNotSource(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode p1 = cur;
            while (p1.next != null && p1.val == p1.next.val) {
                p1 = p1.next;
            }
            cur.next = p1.next;
            cur = cur.next;
        }
        return head;
    }

    @Test
    public void t1() {
        System.out.println(deleteDuplicates(ListNode.convert(new int[]{1, 1, 1, 2, 3})));

        System.out.println(deleteDuplicates(ListNode.convert(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 4, 4})));
        System.out.println(deleteDuplicates(ListNode.convert(new int[]{1, 2, 3, 3, 4, 4, 5})));
    }

    private ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyCur = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            ListNode p1 = cur;
            boolean isDup = false;
            while (p1.next != null && p1.val == p1.next.val) {
                p1 = p1.next;
                isDup = true;
            }
            if (isDup) {

                cur = p1.next;

            } else {
                ListNode remain = p1.next;

                p1.next = null;
                dummyCur.next = p1;
                dummyCur = dummyCur.next;

                cur = remain;
            }

        }

        return dummyNode.next;
    }
}
