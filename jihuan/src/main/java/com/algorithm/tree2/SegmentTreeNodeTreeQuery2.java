package com.algorithm.tree2;

public class SegmentTreeNodeTreeQuery2 {
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start > end || root==null)
            return 0;
        if(start <= root.start && root.end <= end) { // 相等
            return root.count;
        }

        int mid = (root.start + root.end)/2;
        int leftsum = 0, rightsum = 0;
        // 左子区
        if(start <= mid) {
            if( mid < end) { // 分裂
                leftsum =  query(root.left, start, mid);
            } else { // 包含
                leftsum = query(root.left, start, end);
            }
        }
        // 右子区
        if(mid < end) { // 分裂 3
            if(start <= mid) {
                rightsum = query(root.right, mid+1, end);
            } else { //  包含
                rightsum = query(root.right, start, end);
            }
        }
        // else 就是不相交
        return leftsum + rightsum;
    }
}
