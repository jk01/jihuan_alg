package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeCloneTree {
    public TreeNode cloneTree(TreeNode root) {
        // Write your code here
        if (root == null)
            return null; //搜到了空节点，直接返回
        TreeNode clone_root = new TreeNode(root.val); //创造当前深度的“根”
        clone_root.left = cloneTree(root.left);  //左子树
        clone_root.right = cloneTree(root.right); //右子树
        return clone_root;
    }
}
