package other.link;

import java.util.LinkedList;
import java.util.Queue;

/**
 * element 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
 * 　　offer 添加一个元素并返回true 如果队列已满，则返回false
 * 　　poll 移除并返问队列头部的元素 如果队列为空，则返回null
 * 　　peek 返回队列头部的元素 如果队列为空，则返回null
 * 　　put 添加一个元素 如果队列满，则阻塞
 * 　　take 移除并返回队列头部的元素 如果队列为空，则阻塞
 *
 */
public class TreeLinkNodeApp {

    /*
     * 利用层次遍历思想（在每层末尾加上一个null元素）
     */
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
}
