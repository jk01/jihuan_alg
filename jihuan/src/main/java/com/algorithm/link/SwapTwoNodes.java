package com.algorithm.link;

public class SwapTwoNodes {

    public static ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node1Prev = null, node2Prev = null;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == v1) {
                node1Prev = cur;
            } else if (cur.next.val == v2) {
                node2Prev = cur;
            }
            cur = cur.next;
        }

        if (node1Prev == null || node2Prev == null) {
            return head;
        }

        if (node2Prev.next == node1Prev) {
            // make sure node2Prev.next is not node1Prev
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }

        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next;
        ListNode node2Next = node2.next;
        if (node1Prev.next == node2Prev) {
            node1Prev.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;

            node2Prev.next = node1;
            node1.next = node2Next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(19);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(8);
        ListNode a6 = new ListNode(7);

        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a4.next =a5;
        a5.next =a6;

        ListNode result = swapNodes(a1,8,4);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }

}
