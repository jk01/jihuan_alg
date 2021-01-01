package com.algorithm.link;

public class AddTwoNumbers2 {
    public static ListNode addLists2(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        return reverse(addList1(l1, l2));
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

    private static ListNode addList1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            tail.next = new ListNode((l1.val + l2.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + l2.val + carry) / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            tail.next = new ListNode((l1.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + carry) / 10;

            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = new ListNode((l2.val + carry) % 10);
            tail = tail.next;
            carry = (l2.val + carry) / 10;

            l2 = l2.next;
        }

        while (carry != 0) {
            tail.next = new ListNode(carry % 10);
            tail = tail.next;
            carry = carry / 10;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(6);
        ListNode a6 = new ListNode(4);

        a1.next =a2;
        a2.next =a3;

        a4.next =a5;
        a5.next =a6;

        ListNode result = addLists2(a1,a4);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
