package com.algorithm.tree;

import com.algorithm.link.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeIncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        // Write your code here.
        TreeNode res = null, prev = null;
        TreeNode cur = root;
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            TreeNode n = stk.pop();
            if (res == null) { //output tree doesn't exist; build it
                res = new TreeNode(n.val);
                prev = res;
            } else { //add to output tree
                prev.right = new TreeNode(n.val);
                prev = prev.right;
            }
            cur = n.right;
        }
        return res;
    }
}
