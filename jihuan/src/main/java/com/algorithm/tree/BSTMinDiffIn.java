package com.algorithm.tree;

import com.algorithm.link.TreeNode;

public class BSTMinDiffIn {
    Integer res = Integer.MAX_VALUE, pre = null;

    public int minDiffInBST(TreeNode root) {
        // Write your code here.
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return res;
    }
}
