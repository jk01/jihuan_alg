package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeInvertBinaryTree {
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}
