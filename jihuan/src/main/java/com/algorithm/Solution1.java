package com.algorithm;

/**
 * Title: 翻转链表 II
 * Description:
 * 翻转链表中第m个节点到第n个节点的部分
 * 样例
 * 给出链表1->2->3->4->5->null， m = 2 和n = 4，返回1->4->3->2->5->null
 * 注意
 * m，n满足1 ≤ m ≤ n ≤ 链表长度
 * 挑战
 * 在原地一次翻转完成
 *
 * @author jihuan
 * @create 2017-09-27 00:27
 * @version: 1.0
 */
public class Solution1 {

    static ListNode head;
    static ListNode tail;

    public static void reverseLinkList(ListNode parent, ListNode current) {
        if (current.next == null) {
            current.next = parent;
            tail = current;
        } else if (current != null) {
            reverseLinkList(current, current.next);
            current.next = parent;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        head = node1;
        while (head != null) {
            System.out.print(head.key + "->");
            head = head.next;
        }
        System.out.println("null");
        System.out.println("----------------");
        System.out.println("----------------");
        reverseLinkList(node1, node1.next);
        node1.next = null;
        while (tail != null) {
            System.out.print(tail.key + "->");
            tail = tail.next;
        }
        System.out.println("null");
    }
}

class ListNode {
    int key;
    ListNode next;

    ListNode(int key) {
        this.key = key;
        this.next = null;
    }
}
