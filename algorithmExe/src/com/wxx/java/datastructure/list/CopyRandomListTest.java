package com.wxx.java.datastructure.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxxstar
 * @create 2023-08-13 9:55
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/9p0yy1/
 */
public class CopyRandomListTest {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);

        map.put(head, newHead);


        Node newTemp = newHead;
        Node oldTemp = head.next;
        while (oldTemp != null) {
            Node newNext = new Node(oldTemp.val);
            newTemp.next = newNext;

            newTemp = newTemp.next;

            map.put(oldTemp, newTemp);

            oldTemp = oldTemp.next;

        }

        Node oldIterator = head;
        while (oldIterator != null) {

            Node oldRandom = oldIterator.random;
            if (oldRandom != null) {
                Node newNode = map.get(oldIterator);
                newNode.random = map.get(oldRandom);
            }
            oldIterator = oldIterator.next;
        }
        return newHead;
    }

    public Node copyRandomListByNoMap(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }

        // 2. 构建各新节点的 random 指向
        cur = head;
        while (cur != null) {
            Node oldRandom = cur.random;
            if (oldRandom != null) {
                cur.next.random = oldRandom.next;
            }
            cur = cur.next.next;
        }

        // 3. 拆分两链表
        Node pre = head;
        Node res = head.next;

        cur = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        // 4、单独处理原链表尾节点
        pre.next = null;
        return res;      // 返回新链表头节点
    }
}