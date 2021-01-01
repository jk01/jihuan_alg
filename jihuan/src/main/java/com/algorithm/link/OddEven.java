package com.algorithm.link;

public class OddEven {
    public static ListNode oddEvenList(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next;
        ListNode evenDummy = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenDummy;
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);

        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a4.next =a5;
        a5.next =a6;

        ListNode result = oddEvenList(a1);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
