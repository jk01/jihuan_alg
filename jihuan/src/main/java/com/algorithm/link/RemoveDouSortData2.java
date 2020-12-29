package com.algorithm.link;

public class RemoveDouSortData2 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(5);
        ListNode a7 = new ListNode(6);
        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a3.next =a4;
        a4.next =a5;
        a5.next =a6;
        a6.next =a7;
        ListNode result = deleteDuplicates(a1);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
