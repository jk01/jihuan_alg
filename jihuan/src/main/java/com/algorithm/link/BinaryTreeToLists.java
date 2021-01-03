package com.algorithm.link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeToLists {
    public static List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<ListNode>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        ListNode dummy = new ListNode(0);
        ListNode lastNode = null;
        while (!queue.isEmpty()) {
            dummy.next = null;
            lastNode = dummy;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                lastNode.next = new ListNode(head.val);
                lastNode = lastNode.next;

                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            result.add(dummy.next);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(5);
        root.left = a1;
        root.right= a2;
        TreeNode a3 = new TreeNode(7);
        a1.left= a3;

        List<ListNode> result = binaryTreeToLists(root);
        for(ListNode res : result) {
            while (res != null) {
                System.out.print(res.val + "->");
                res = res.next;
            }
            System.out.println();
        }
    }
}

