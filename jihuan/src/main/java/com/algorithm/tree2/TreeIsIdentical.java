package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeIsIdentical {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if (a == null && b == null)
            return true;
        if (a != null && b != null) {
            return a.val == b.val && isIdentical(a.left, b.left)
                    && isIdentical(a.right, b.right);
        }
        return false;
    }
}
