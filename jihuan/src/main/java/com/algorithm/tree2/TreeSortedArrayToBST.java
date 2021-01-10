package com.algorithm.tree2;

import com.algorithm.link.TreeNode;

public class TreeSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        int len = A.length;
        TreeNode root = null;
        root = recursion(A, 1, len, root);
        A = null;
        return root;
    }
    public TreeNode recursion(int[] array, int lhs, int rhs, TreeNode root)
    {
        if(lhs <= rhs)
        {
            int mid = (lhs + rhs + 1) >> 1;
            root = new TreeNode(array[mid-1]);
            root.left = recursion(array, lhs, mid - 1, root.left);
            root.right = recursion(array, mid + 1, rhs, root.right);
        }
        return root;
    }
}
