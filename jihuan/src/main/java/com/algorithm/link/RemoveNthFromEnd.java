package com.algorithm.link;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(2);
        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        ListNode result = removeNthFromEnd(a1, 2);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
