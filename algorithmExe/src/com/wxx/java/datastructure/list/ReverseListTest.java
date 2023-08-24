package com.wxx.java.datastructure.list;

/**
 * @author lhbac
 * @create 2023/8/21 20:37
 * <a href="https://leetcode.cn/problems/UHnkqh/solutions/">...</a>
 */
public class ReverseListTest {

    /**
     * 创建新节点
     * <p>
     * 保存当前节点的前一个节点，后一个节点
     * 当前节点的下一个节点指向前一个节点
     * 并更新最新的节点为链接新节点
     *
     * @param head
     * @return
     */
    public ListNode reverseListByIteration(ListNode head) {
        ListNode ret = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode remain = cur.next;

            cur.next = ret;
            ret = cur;

            cur = remain;

        }
        return ret;
    }

    /**
     * @param head
     * @return
     */
    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseListByIteration(head);
        return recur(head, null);
    }

    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {//说明pre已经是最后一个节点
            return pre;
        }
        ListNode res = recur(cur.next, cur);
        cur.next = pre;
        return res;
    }
}
