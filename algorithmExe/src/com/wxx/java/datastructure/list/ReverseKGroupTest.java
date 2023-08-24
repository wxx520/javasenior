package com.wxx.java.datastructure.list;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lhbac
 * @create 2023/8/22 13:40
 */
public class ReverseKGroupTest {

    /**
     * 使用双向队列，并计数，到达k先进后取
     * 不到k则先进先取并终止
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupByDeque(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);

        ListNode dummyCur = dummyNode;
        ListNode cur = head;
        int count = 0;
        Deque<ListNode> deque = new ArrayDeque<>(k);

        while (cur != null) {
            //不断向队列中添加元素
            ListNode temp = cur.next;

            cur.next = null;
            deque.offerLast(cur);
            count++;

            cur = temp;

            //当前节点为第k个节点，到k个则开始处理
            if (count == k) {
                //前一批处理完的最后一个节点为新一批的首元素
                ListNode curFirst = dummyCur;
                while (!deque.isEmpty()) {
                    curFirst.next = deque.pollLast();
                    curFirst = curFirst.next;
                }
                //当前批的最后一个节点是下一批的首元素
                dummyCur = curFirst;
                count = 0;
            }
        }
        //队列不为空，说明当前元素数不够k，则顺序取出
        while (!deque.isEmpty()) {
            dummyCur.next = deque.pollFirst();
            dummyCur = dummyCur.next;
        }

        return dummyNode.next;
    }

    /**
     * 逐段反转，当发现不够时则再反转回来
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        //
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        //curDummy前一批处理完成后的最后一个节点，即下一批待逆序的首个元素的前一个节点
        ListNode curDummy = dummyNode;

        ListNode cur = head;
        int curK = k;
        while (cur != null) {
            //积累一批
            if (curK > 0) {
                cur = cur.next;
                curK--;
            }
            //到达批处理的条件{Nmk+1,...,Nmk+k}，逆序处理当前批，处理完成后{Nmk+k,...,Nmk+1}
            //将curDummy.next与处理完成后的新head关联，即curDummy.next=Nmk+k
            //curDummy继续指向下一批的前一个元素，即当前批的最后一个元素，即
            //    curDummy = Nmk+1
            //    curDummy.next = Nmk+k+1
            if(curK==0){
                ListNode curHead = curDummy.next;
                ListNode pre = null;
                ListNode oldHead = null;
                while (curK < k) {
                    curK++;
                    ListNode remain = curHead.next;
                    curHead.next = pre;
                    pre = curHead;
                    curHead = remain;

                    if (curK == 1) {
                        oldHead = pre;
                    }
                }

                curDummy.next = pre;
                oldHead.next = cur;
                curDummy = oldHead;
            }

        }
        return dummyNode.next;
    }

    public ListNode reverseKGroupByRecur(ListNode head, int k) {
        // 使用递归写法的话，先考虑特殊情况
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        // 探测长度的结点
        ListNode tempNode = head;
        int curK = k;
        while (tempNode != null && curK != 0) {
            curK--;
            tempNode = tempNode.next;
        }
        // 如果够数了，先考虑反转
        if (curK == 0) {
            // 下面开始反转
            ListNode pre = null;
            ListNode curNode = head;
            for (int i = 0; i < k; i++) {
                ListNode nextNode = curNode.next;
                curNode.next = pre;
                pre = curNode;
                curNode = nextNode;
            }
            head.next = reverseKGroupByRecur(tempNode, k);
            return pre;
        }
        return head;
    }

    @Test
    public void t1() {
        System.out.println(reverseKGroup(ListNode.convert(new int[]{1, 2,3,4,5}), 2));
    }
}
