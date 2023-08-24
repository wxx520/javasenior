package com.wxx.java.datastructure.list;

import org.junit.Test;

/**
 * @author lhbac
 * @create 2023/8/22 20:33
 */
public class PartitionListByX {

    /**
     * 准备两个新链表，依次连接小于x和不小于x的节点，
     * 循环遍历head，依次放入，直至队尾
     * 最后连接两个新链表作为返回结果
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode min = new ListNode(-1);
        ListNode max = new ListNode(-2);

        ListNode minCur = min;
        ListNode maxCur = max;
        ListNode cur = head;
        while (cur != null) {
            ListNode remain = cur.next;
            cur.next = null;
            if (cur.val < x) {
                minCur.next = cur;
                minCur = minCur.next;
            } else {
                maxCur.next = cur;
                maxCur = maxCur.next;
            }
            cur = remain;
        }
        //将不小于x的节点链接到小于x的链表结尾
        minCur.next = max.next;
        max.next = null;
        return min.next;
    }

    @Test
    public void t1(){
        System.out.println(partition(ListNode.convert(new int[]{1,4,3,2,5,2}),3));
        System.out.println(partition(ListNode.convert(new int[]{2,1}),2));
        System.out.println(partition(ListNode.convert(new int[]{}),2));
    }
}
