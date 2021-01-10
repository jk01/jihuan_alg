package com.algorithm.tree;

import com.algorithm.link.TreeNode;

public class TreeSearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        // Write your code here.
        if(root == null || root.val == val) return root;
        if(val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
