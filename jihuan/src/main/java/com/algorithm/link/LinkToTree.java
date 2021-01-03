package com.algorithm.link;

public class LinkToTree {

    public static class Pair{
        TreeNode root;
        ListNode next;

        public Pair(TreeNode root, ListNode next) {
            this.root = root;
            this.next = next;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = getLinkedListLength(head);

        Pair pair = convert(head, length);
        return pair.root;
    }

    public int getLinkedListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public Pair convert(ListNode head, int length) {
        /**
         * Convert head -> head.next ....       head.next.next... -> next
         *           |_______________________________|
         *                        length
         * to a Balanced-BST and return the root of the BST and the
         * (length + 1)th node from head.
         */

        if (length == 0) {
            return new Pair(null, head);
        }

        // convert the first length / 2 nodes to a left child tree node.
        Pair leftPair = convert(head, length / 2);
        // convert linked list from (length / 2 + 2)th node as head to a right child tree node
        Pair rightPair = convert(leftPair.next.next, length - length / 2 - 1);

        // so the (length / 2 + 1)th node will be directly converted to the root node.
        //        pair.root
        //     /              \
        // leftPair.root  rightPair.root
        Pair pair = new Pair(new TreeNode(leftPair.next.val), null);
        pair.root.left = leftPair.root;
        pair.root.right = rightPair.root;
        pair.next = rightPair.next;

        return pair;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(1);
        ListNode a6 = new ListNode(1);

        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        a4.next =a5;
        a5.next =a6;
        LinkToTree linkToTree = new LinkToTree();
        TreeNode result = linkToTree.sortedListToBST(a1);
        System.out.print(result.toString());
    }
}
