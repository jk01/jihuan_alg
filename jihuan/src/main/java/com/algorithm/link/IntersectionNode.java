package com.algorithm.link;

public class IntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // get the tail of list A.
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;
        ListNode result = listCycleII(headA);
        node.next = null;
        return result;
    }

    private static ListNode listCycleII(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
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
        a7.next = a8.next;

        a1.next =a2;
        a2.next =a3;
        a3.next =a7;

        a4.next =a5;
        a5.next =a6;
        a6.next =a7;

        ListNode result = getIntersectionNode(a1,a4);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
