package com.algorithm.link;

public class ListSort {
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);

        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(6);
        ListNode a6 = new ListNode(4);
        ListNode a7 = new ListNode(8);
        ListNode a8 = new ListNode(9);


        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
//        a4.next =a5;
//        a5.next =a6;
//        a6.next =a7;
//        a7.next =a8;
        ListNode result = sortList(a1);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
