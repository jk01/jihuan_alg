package com.algorithm.tree;

import com.algorithm.link.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeClosestValue2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();

        traverse(root, values);

        int i = 0, n = values.size();
        for (; i < n; i++) {
            if (values.get(i) >= target) {
                break;
            }
        }

        if (i >= n) {
            return values.subList(n - k, n);
        }

        int left = i - 1, right = i;
        List<Integer> result = new ArrayList<>();
        for (i = 0; i < k; i++) {
            if (left >= 0 && (right >= n || target - values.get(left) < values.get(right) - target)) {
                result.add(values.get(left));
                left--;
            } else {
                result.add(values.get(right));
                right++;
            }
        }

        return result;
    }

    private void traverse(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        traverse(root.left, values);
        values.add(root.val);
        traverse(root.right, values);
    }
}
