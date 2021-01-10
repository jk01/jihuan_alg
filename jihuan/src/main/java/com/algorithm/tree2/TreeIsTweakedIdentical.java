package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeIsTweakedIdentical {
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }

        if (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)) {
            return true;
        }

        if (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)) {
            return true;
        }

        return false;
    }
}
