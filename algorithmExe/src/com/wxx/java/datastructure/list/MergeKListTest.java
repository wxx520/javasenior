package com.wxx.java.datastructure.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lhbac
 * @create 2023/8/19 9:28
 */
public class MergeKListTest {

    public ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        } else if (len == 1) {
            return lists[0];
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            curNode.next = minNode;
            curNode = curNode.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return dummyNode.next;
    }


    /***
     * 链表两两比较，list[0],list[1],得到新链表dummyNode，长度为N0+N1,
     * 然后继续与list[2]
     * ...
     * list[k-1]比较，等到最终结果
     * 时间复杂度为N0+...+Nk-1
     * @param lists
     * @return
     */
    public ListNode mergeKListsBy22Compare(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        } else if (len == 1) {
            return lists[0];
        }
        return merge(lists, 0, len - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[right];
        }
        if (left > right) {
            return null;
        }
        int m = (left+right)>>1;
        return mergeListNode(merge(lists, 0, m), merge(lists, m + 1, right));
    }


    private ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode resCur = res;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (true) {
            if (temp1 == null) {
                resCur.next = temp2;
                break;
            }
            if (temp2 == null) {
                resCur.next = temp1;
                break;
            }
            if (temp2.val < temp1.val) {
                ListNode temp2Remain = temp2.next;

                temp2.next = null;
                resCur.next = temp2;

                temp2 = temp2Remain;
            } else {
                ListNode temp1Remain = temp1.next;
                temp1.next = null;
                resCur.next = temp1;

                temp1 = temp1Remain;
            }

            resCur = resCur.next;
        }
        return res.next;
    }
}
