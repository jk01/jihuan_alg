package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeLevelNoteSum {
    private int sum = 0;
    public int levelSum(TreeNode root, int level) {
        helper(root, 1, level);
        return sum;
    }

    private void helper(TreeNode root, int depth, int level) {
        if (root == null) {
            return;
        }

        if (depth == level) {
            sum += root.val;
            return;
        }

        helper(root.left, depth + 1, level);
        helper(root.right, depth + 1, level);
    }
}
