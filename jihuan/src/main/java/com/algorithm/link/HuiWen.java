package com.algorithm.link;

public class HuiWen {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);

        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2 == null;
    }

    private static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(1);
//        ListNode a6 = new ListNode(1);

        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a4.next =a5;
//        a5.next =a6;

        Boolean result = isPalindrome(a1);
        System.out.print(result);
    }
}

