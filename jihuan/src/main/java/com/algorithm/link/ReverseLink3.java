package com.algorithm.link;

public class ReverseLink3 {

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next, n2 = head.next.next;
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            head = n1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(19);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(8);
        ListNode a6 = new ListNode(7);

        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a4.next =a5;
        a5.next =a6;

        ListNode result = swapPairs(a1);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
