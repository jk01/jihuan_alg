package com.algorithm.link;

import java.util.HashSet;

public class RemoveDouNoSortData {
    public static ListNode removeDuplicates(ListNode head) {
        HashSet<Integer> hash = new HashSet<Integer>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            if (hash.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                hash.add(head.next.val);
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(7);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(5);
        ListNode a7 = new ListNode(4);
        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a3.next =a4;
        a4.next =a5;
        a5.next =a6;
        a6.next =a7;
        ListNode result = removeDuplicates(a1);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
