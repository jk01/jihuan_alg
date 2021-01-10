package com.algorithm.tree;

import com.algorithm.link.TreeNode;

public class TwoSumTree {
    TreeNode root;

    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if (root == null || (root.left == null && root.right == null)) return null;
        this.root = root;
        return inorder(root, n);
    }

    public int[] inorder(TreeNode root, int n) {
        if (root == null) return null;

        int[] res = null;
        int[] left = inorder(root.left, n);
        if (find(this.root, n - root.val, root)) {
            res = new int[2];
            res[0] = root.val;
            res[1] = n - root.val;
            return res;
        }
        int[] right = inorder(root.right, n);
        return left != null ? left : right;
    }

    public boolean find(TreeNode root, int target, TreeNode pre) {
        if (root == null) return false;

        if (root.val == target && root != pre) return true;
        if (root.val < target) return find(root.right, target, pre);
        else return find(root.left, target, pre);
    }
}
