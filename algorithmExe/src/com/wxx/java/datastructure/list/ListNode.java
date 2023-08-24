package com.wxx.java.datastructure.list;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode p = this;
        StringBuffer s = new StringBuffer();
        while (p != null) {
            s.append(p.val);
            p = p.next;
        }
        return s.toString();
    }

    public static ListNode convert(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode node = new ListNode(arr[0]);
        ListNode cur = node;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(l);
    }
}
