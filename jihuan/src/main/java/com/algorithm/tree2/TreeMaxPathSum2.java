package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeMaxPathSum2 {
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return root.val + Math.max(0, Math.max(left, right));
    }
}
