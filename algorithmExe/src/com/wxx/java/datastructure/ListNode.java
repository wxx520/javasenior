package com.wxx.java.datastructure;

public class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
         ListNode p = this;
         StringBuffer s = new StringBuffer();
         while (p!=null){
             s.append(p.val);
             p = p.next;
         }
        return s.toString();
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1,new ListNode(2,new ListNode(3)));
        System.out.println(l);
    }
}
