package com.algorithm.link;

public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (true) {
            head = reverseK(head, k);
            if (head == null) {
                break;
            }
        }

        return dummy.next;
    }

    // head -> n1 -> n2 ... nk -> nk+1
    // =>
    // head -> nk -> nk-1 .. n1 -> nk+1
    // return n1
    public static ListNode reverseK(ListNode head, int k) {
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }

        if (nk == null) {
            return null;
        }

        // reverse
        ListNode n1 = head.next;
        ListNode nkplus = nk.next;

        ListNode prev = null;
        ListNode curt = n1;
        while (curt != nkplus) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }

        // connect
        head.next = nk;
        n1.next = nkplus;
        return n1;
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
        ListNode result = reverseKGroup(a1,2);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
