package com.algorithm.tree;

import com.algorithm.link.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeToDoublyList {
    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        helper(root, list);

        TreeNode head = list.get(0);
        TreeNode tail = list.get(list.size() - 1);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void helper(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        helper(node.left, list);
        list.add(node);
        if (list.size() >= 2) {
            int n = list.size();
            TreeNode a = list.get(n - 2);
            TreeNode b = list.get(n - 1);
            a.right = b;
            b.left = a;
        }
        helper(node.right, list);
    }
}
