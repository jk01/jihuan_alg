package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeMaxNode {
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if (root == null)
            return root;

        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        return max(root, max(left, right));
    }

    TreeNode max(TreeNode a, TreeNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.val > b.val) {
            return a;
        }
        return b;
    }
}
