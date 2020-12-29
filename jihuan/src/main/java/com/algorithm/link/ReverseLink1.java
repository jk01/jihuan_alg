package com.algorithm.link;

public class ReverseLink1 {
    public static ListNode reverse(ListNode head) {
        //prev表示前继节点
        ListNode prev = null;
        while (head != null) {
            //temp记录下一个节点，head是当前节点
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        System.out.println("----before----");
        ListNode head=a1;
        while(a1!=null){
            System.out.print(a1.val+"->");
            a1 = a1.next;
        }
        System.out.println("");
        System.out.println("----after-----");
        ListNode tail = reverse(head);
        while(tail!=null){
            System.out.print(tail.val+"->");
            tail = tail.next;
        }
    }
}
