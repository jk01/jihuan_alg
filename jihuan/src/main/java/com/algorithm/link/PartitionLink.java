package com.algorithm.link;

public class PartitionLink {
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }

        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
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

        ListNode result = partition(a1,4);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
