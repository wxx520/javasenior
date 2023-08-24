package com.wxx.java.datastructure.list;

import org.junit.Test;

/**
 * @author lhbac
 * @create 2023/8/22 21:38
 */
public class ReverseListBetweenLR {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || right == left) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);//参与反转的第一个节点的前一个节点
        dummyNode.next = head;

        ListNode cur = head;
        int curLeft = left;
        ListNode pre = dummyNode;
        while (curLeft > 1) {
            pre = cur;
            cur = cur.next;
            curLeft--;
        }

        int curRight = right - left + 1;
        ListNode reversePre = null;
        ListNode reverseBeginNode = cur;//参与反转的第一个节点，也是反转后的最后一个节点
        while (cur != null && curRight > 0) {
            ListNode remain = cur.next;

            cur.next = reversePre;
            reversePre = cur;

            cur = remain;

            curRight--;

        }

        pre.next = reversePre;
        reverseBeginNode.next = cur;
        return dummyNode.next;
    }

    @Test
    public void t1() {
        System.out.println(reverseBetween(ListNode.convert(new int[]{3, 5}), 1, 2));
        System.out.println(reverseBetween(ListNode.convert(new int[]{1, 2, 3, 4, 5}), 2, 4));
        System.out.println(reverseBetween(ListNode.convert(new int[]{5}), 1, 1));
    }
}
