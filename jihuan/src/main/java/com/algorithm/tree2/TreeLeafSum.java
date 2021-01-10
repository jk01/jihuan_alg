package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeLeafSum {
    private int sum = 0;
    public int leafSum(TreeNode root) {
        helper(root);
        return sum;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        helper(root.left);
        helper(root.right);
    }
}
