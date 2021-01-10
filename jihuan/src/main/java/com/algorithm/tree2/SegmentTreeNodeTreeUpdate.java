package com.algorithm.tree2;

public class SegmentTreeNodeTreeUpdate {
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index) { // 查找到
            root.max = value;
            return;
        }

        // 查询
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modify(root.left, index, value);
        }

        if(mid < index && index <= root.end) {
            modify(root.right, index, value);
        }
        //更新
        root.max = Math.max(root.left.max, root.right.max);
    }
}
