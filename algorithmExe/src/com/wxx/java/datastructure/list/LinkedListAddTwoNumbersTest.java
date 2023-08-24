package com.wxx.java.datastructure.list;

import org.junit.Test;

public class LinkedListAddTwoNumbersTest {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * <p>
     * 遍历两个链表，
     * 1、从首个链表节点开始相加，
     * 2、若遇到当个空节点则当成0处理，保留当前节点之和的进位
     * 3、直至两个节点都为空
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode pre1 = l1;
        ListNode pre2 = l2;
        ListNode pre3 = l3;
        int carryBit = 0;
        while (pre2 != null || pre1 != null) {
            if (pre1 != null) {
                carryBit += pre1.val;
                pre1 = pre1.next;
            }
            if (pre2 != null) {
                carryBit += pre2.val;
                pre2 = pre2.next;
            }
            pre3.next = new ListNode(carryBit % 10);
            carryBit = carryBit / 10;
            pre3 = pre3.next;
        }
        if (carryBit == 1) {
            pre3.next = new ListNode(1);
        }
        return l3.next;
    }

    @Test
    public void t1() {
        ListNode ret = addTwoNumbers(convert(new int[]{3, 2, 0, 2, 6, 0, 8, 8, 0, 1}), convert(new int[]{0, 8, 9, 6, 8, 7, 2}));
        System.out.println(ret);
    }

    private ListNode convert(int[] arr) {
        ListNode ret = new ListNode(arr[0]);
        ListNode cur = ret;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return ret;
    }

}
