package com.wxx.java.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxxstar
 * @create 2023-04-17 22:15
 *
 *
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "[" + val + next  + "]";
    }
}

public class LinkedListDeepCopy {



    /**
     * 1、复制OldHead至newHead，仅保存next、val值；并将新老node节点映射关系保存在map中
     * 2、遍历老head，根据head每个oldNode的random引用，在map中查找对应的newNodeRandom，该newNodeRandom
     * 即为新newNode的random
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        Map<Node,Node> nodeMap = new HashMap<>();
        Node newHead = new Node(head.val);
        nodeMap.put(head,newHead);

        Node newTemp = newHead;
        Node oldTemp = head.next;
        while (oldTemp!=null){
            Node newNext = new Node(oldTemp.val);
            newTemp.next = newNext;
            nodeMap.put(oldTemp,newNext);
            oldTemp=oldTemp.next;
            newTemp=newTemp.next;
        }

        Node oldIterator = head;
        while (oldIterator!=null){
            Node oldRandom = oldIterator.random;
            if(oldRandom!=null){
                Node newNode = nodeMap.get(oldIterator);
                Node newRandom = nodeMap.get(oldRandom);
                newNode.random = newRandom;
            }
            oldIterator=oldIterator.next;
        }

        return newHead;
    }

    /**
     * 注意到方法一需要使用哈希表记录每一个节点对应新节点的创建情况，而我们可以使用一个小技巧来省去哈希表的空间
     *我们首先将该链表中每一个节点拆分为两个相连的节点，例如对于链表
     * A→B→C，我们可以将其拆分为A→A′→B→B′→C→C′。
     * 对于任意一个原节点S，其拷贝节点S′即为其后继节点。这样，我们可以直接找到每一个拷贝节点S′
     * 的随机指针应当指向的节点，即为其原节点S 的随机指针指向的节点T 的后继节点T′。
     * 需要注意原节点的随机指针可能为空，我们需要特别判断这种情况。
     *
     * 当我们完成了拷贝节点的随机指针的赋值，我们只需要将这个链表按照原节点与拷贝节点的种类进行拆分即可，只需要遍历一次。同样需要注意最后一个拷贝节点的后继节点为空，我们需要特别判断这种情况。
     *
     * @param head
     * @return
     */
    public Node copyRandomListByDoubleNode(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
