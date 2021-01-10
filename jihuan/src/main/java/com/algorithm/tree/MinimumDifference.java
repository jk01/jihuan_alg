package com.algorithm.tree;

import com.algorithm.link.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        // Write your code here
        List<Integer> numsList = new ArrayList<Integer>();
        preTraversal(root, numsList);
        Integer[] nums = new Integer[numsList.size()];
        numsList.toArray(nums);
        int ans = nums[1] - nums[0];
        for(int i = 2; i < nums.length; ++i) ans=Math.min(ans, nums[i] - nums[i-1]);
        return ans;
    }

    public void preTraversal(TreeNode root,List<Integer> nums) {
        if (root == null)
            return;
        preTraversal(root.left, nums);
        nums.add(root.val);
        preTraversal(root.right, nums);
    }
}
