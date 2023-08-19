package com.wxx.java.datastructure;

import com.wxx.java.datastructure.list.ListNode;
import org.junit.Test;

/**
 * @author wxxstar
 * @create 2023-08-12 22:41
 */
public class ListNodeReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode reverse = new ListNode(head.val);
        ListNode temp = head.next;
        while (temp != null) {
            ListNode node = new ListNode(temp.val);
            node.next = reverse;
            reverse = node;
            temp = temp.next;
        }
        return reverse;
    }

    @Test
    public void t1(){
        ListNode node = new ListNode(0);
        ListNode tmp = node;
        for (int i = 1; i < 6; i++) {
            ListNode n1 = new ListNode(i);
            tmp.next = n1;
            tmp = n1;
        }

        ListNode reverse = reverseList(node);
        System.out.println(node);
    }
}
