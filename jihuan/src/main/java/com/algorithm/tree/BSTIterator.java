package com.algorithm.tree;

import com.algorithm.link.TreeNode;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    // @param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        TreeNode curt = stack.peek();
        TreeNode node = curt;

        // move to the next node
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        } else {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return curt;
    }
}
