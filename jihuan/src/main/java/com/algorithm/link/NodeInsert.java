package com.algorithm.link;

public class NodeInsert {
    public static ListNode insertNode(ListNode head, int val) {
        ListNode node = new ListNode(val);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        // find the last element <= val
        while (head.next != null && head.next.val <= val) {
            head = head.next;
        }
        node.next = head.next;
        head.next = node;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(10);
        ListNode a4 = new ListNode(14);
        ListNode a5 = new ListNode(18);
        ListNode a6 = new ListNode(7);

        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a4.next =a5;
        a5.next =a6;

        ListNode result = insertNode(a1,9);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
