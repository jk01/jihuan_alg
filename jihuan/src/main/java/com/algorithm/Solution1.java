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
    /**
     * 求链表的三等分点
     */
    public static void threePoint(ListNode current){
        //先判断长度是否为3的倍数

        //第三个点的走到最后一个节点，停止
        ListNode first = current.next;
        ListNode two = current.next.next;
        ListNode three = current.next.next.next;
        ListNode dNode = three;
        while(dNode.next != null){
             first = dNode.next;
             two = dNode.next.next;
             three = dNode.next.next.next;
             dNode = three;
        }
    }

    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if( m>=n || head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        // 找到旋转链表的第一个节点
        for(int i=1;i<m;i++){
            if( head ==null)
                return null;
            head = head.next;
        }
        // 第m个节点的前一个节点
        ListNode premNode = head;
        // 第m个节点
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = mNode.next;
        for(int i=m;i< n;i++){
            if(postnNode == null){
                return null;
            }
            // 旋转
            ListNode tmp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = tmp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
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
