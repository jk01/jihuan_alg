package com.algorithm.link;

public class FindNthLast {
   public static ListNode nthToLast(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        for (int j = 0; j < n - 1; ++j) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);

        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a4.next =a5;
        a5.next =a6;

        ListNode result = nthToLast(a1,1);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
