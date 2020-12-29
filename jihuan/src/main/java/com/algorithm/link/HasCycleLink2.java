package com.algorithm.link;

public class HasCycleLink2 {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }

        ListNode fast, slow;
        fast = head.next;    		//快指针
        slow = head;				//慢指针
        while (fast != slow) {		//快慢指针相遇
            if(fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        while (head != slow.next) {  //同时移动head和慢指针
            head = head.next;
            slow = slow.next;
        }
        return head;				//两指针相遇处即为环的入口
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(7);
        ListNode a6 = new ListNode(8);
        ListNode a7 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a3;
        ListNode head= a1;
//        while(a1!=null){
//            System.out.print(a1.val+"->");
//            a1= a1.next;
//        }
        System.out.println();
        ListNode result = detectCycle(head);
        System.out.println(result.val);
    }
}
