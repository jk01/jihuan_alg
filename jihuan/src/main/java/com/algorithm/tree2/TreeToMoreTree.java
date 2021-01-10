package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeToMoreTree {
    int sum = 0;

    void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.right);
        sum += cur.val;
        cur.val = sum;
        dfs(cur.left);
    }

    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        dfs(root);
        return root;
    }
}
