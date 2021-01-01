package com.algorithm.link;

public class FindMiddleNode {
    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(2);
        ListNode a6 = new ListNode(1);

        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a4.next =a5;
        a5.next =a6;

        ListNode result = middleNode(a1);
        System.out.print(result.val+"->");
    }
}
