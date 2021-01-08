package com.algorithm.tree;


import java.util.LinkedList;
import java.util.Queue;

public class TraverseLevelLinked {
    public void connect(TreeLinkNode root){
        if(root==null){
            return;
        }
        Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeLinkNode node=queue.poll();
            if(node!=null){
                node.next=queue.peek();
            }

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

            TreeLinkNode next=queue.peek();
            if(next==null){
                queue.remove();
                if(!queue.isEmpty())
                    queue.add(null);
            }
        }
    }

    public void connect2(TreeLinkNode root){
        if(root==null){
            return;
        }
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;
        }
        if(root.next!=null && root.right!=null){
            root.right.next=root.next.left;
        }
        connect2(root.left);
        connect2(root.right);
    }

    public static class TreeLinkNode{
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }
}
