package com.algorithm.link;

public class HasCycleLink1 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a2;
        ListNode head= a1;
//        while(a1!=null){
//            System.out.print(a1.val+"->");
//            a1= a1.next;
//        }
        System.out.println();
        Boolean result = hasCycle(head);
        System.out.println(result);
    }
}
