package com.algorithm.link;

public class SortInsert {
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
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

        ListNode result = insertionSortList(a1);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
