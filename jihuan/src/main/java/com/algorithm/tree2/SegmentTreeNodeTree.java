package com.algorithm.tree2;

public class SegmentTreeNodeTree {
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if(start > end) {  // check core case
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);

        if(start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid+1, end);

            // root.max = Math.max(root.left.max, root.right.max);
        }
        return root;
    }
}

  class SegmentTreeNode {
      public int start, end, max,count;
      public SegmentTreeNode left, right;
      public SegmentTreeNode(int start, int end) {
          this.start = start;
          this.end = end;

          this.left = this.right = null;
      }
  }
