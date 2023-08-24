package com.wxx.java.datastructure.list;

/**
 * @author lhbac
 * @create 2023/8/22 12:55
 * <p>
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 */
public class ListSwapPairsTest {

    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
     * <p>
     * cur
     * p1
     * p2
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 这里设置 dummyNode 是为了处理头结点的特殊情况
        // 使得头结点和非头结点可以统一处理
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode cur = dummyNode;
        ListNode p1 = null;
        ListNode p2 = null;
        while (cur.next != null && cur.next.next != null) {
            // 重新初始化 p1 和 p2
            p1 = cur.next;
            p2 = cur.next.next;

            // "穿针引线"的步骤就 3 步
            p1.next = p2.next;
            p2.next = p1;
            cur.next = p2;

            // 循环变量更新
            cur = p1;

        }

        return dummyNode.next;
    }

    public ListNode swapPairsByRecursion(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return head;
        }

        // 没有必要设置虚拟头结点了
        ListNode p1 = head;
        ListNode p2 = head.next;

        p1.next = swapPairsByRecursion(p2.next);
        p2.next = p1;
        return p2;
    }
}
