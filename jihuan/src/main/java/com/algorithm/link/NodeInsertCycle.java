package com.algorithm.link;

public class NodeInsertCycle {
    public static ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }

        ListNode p = node;
        ListNode prev = null;
        do {
            prev = p;
            p = p.next;
            if (x <= p.val && x >= prev.val) {
                break;
            }
            if ((prev.val > p.val) && (x < p.val || x > prev.val)) {
                break;
            }
        } while (p != node);

        ListNode newNode = new ListNode(x);
        newNode.next = p;
        prev.next = newNode;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(7);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(3);


        a1.next =a2;
        a2.next =a3;
        a3.next =a1;

        ListNode result = insert(a1,4);
        int num=1;
        while(result!=null&&num<=4){
            System.out.print(result.val+"->");
            result = result.next;
            num++;
        }
    }
}
