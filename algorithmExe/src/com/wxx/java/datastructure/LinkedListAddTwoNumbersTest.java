package com.wxx.java.datastructure;

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
        ListNode l3 = new ListNode();
        ListNode pre1 = l1;
        ListNode pre2 = l2;
        ListNode pre3 = l3;
        int carryBit = 0;
        int currentNodeValue = 0;
        while (pre2 != null || pre1 != null) {
            if (pre1 == null) {
                currentNodeValue = pre2.val + carryBit;
                pre2 = pre2.next;

            } else if (pre2 == null) {
                currentNodeValue = pre1.val + carryBit;
                pre1 = pre1.next;
            } else {
                currentNodeValue = pre1.val + pre2.val + carryBit;
                pre1 = pre1.next;
                pre2 = pre2.next;
            }

            if (currentNodeValue > 9) {
                carryBit = 1;
                currentNodeValue = currentNodeValue - 10;
            } else {
                carryBit = 0;
            }
            pre3.val = currentNodeValue;
            //是否有下个节点判断
            if (pre1 != null || pre2 != null) {
                pre3.next = new ListNode();
                pre3 = pre3.next;
            } else if (carryBit > 0) {
                pre3.next = new ListNode(1);
                pre3 = pre3.next;
            }

        }
        return l3;
    }

}
