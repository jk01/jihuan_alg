package com.algorithm.link;

public class MergeTwoLink {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(6);
        ListNode a6 = new ListNode(4);

        a1.next =a2;
        a2.next =a3;

        a4.next =a5;
        a5.next =a6;

        ListNode result = mergeTwoLists(a1,a4);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
