package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeLongestConsecutive {
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode parent, int lengthWithoutRoot) {
        if (root == null) {
            return 0;
        }

        int length = (parent != null && parent.val + 1 == root.val)
                ? lengthWithoutRoot + 1
                : 1;
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        return Math.max(length, Math.max(left, right));
    }
}
