package com.wxx.java.datastructure.list;

/**
 * @author lhbac
 * @create 2023/8/21 21:49
 */
public class MergeTwoSortedList {

    /**
     * 1、创建一个新链表
     * 2、l1和l2不断比较当前node的值，较小的则插入新链表中，被插入的不断往后移，
     * 由一方为空时，剩余链表直接链接到新链表结尾
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ret = new ListNode(-1);
        ListNode curRet = ret;
        ListNode pre1 = list1;
        ListNode pre2 = list2;
        while (pre1 != null || pre2 != null) {
            if (pre1 == null) {
                curRet.next = pre2;
                break;
            }

            if (pre2 == null) {
                curRet.next = pre1;
                break;
            }
            if (pre1.val <= pre2.val) {
                curRet.next = new ListNode(pre1.val);
                curRet = curRet.next;
                pre1 = pre1.next;
            } else {
                curRet.next = new ListNode(pre2.val);
                curRet = curRet.next;
                pre2 = pre2.next;
            }
        }
        return ret.next;
    }
}
