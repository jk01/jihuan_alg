package other.link;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTravel {


        public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            // write your code here
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(root == null)
                return result;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            //正反向标志
            boolean isForward = true;
            queue.offer(root);
            while(!queue.isEmpty()) {
                //由于下面还要向queue里面添加节点，这个size就是上一层的节点总数
                int size = queue.size();
                List<Integer> subList = new ArrayList<Integer>();
                for(int i = 0 ; i < size ; i++) {
                    TreeNode current = queue.poll();
                    if(isForward)
                        subList.add(current.val);
                    else
                        subList.add(0,current.val);
                    if(current.left != null)
                        queue.offer(current.left);
                    if(current.right != null)
                        queue.offer(current.right);
                }
                result.add(subList);
                //方向反转
                isForward = !isForward;
            }
            return result;
        }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result.toString());
    }

public static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

}
