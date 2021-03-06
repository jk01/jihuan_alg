package com.algorithm.tree;

import com.algorithm.link.TreeNode;

public class ValidateBST {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean divConq(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return divConq(root.left, min, Math.min(max, root.val)) &&
                divConq(root.right, Math.max(min, root.val), max);
    }
}
