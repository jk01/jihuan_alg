package com.algorithm.tree;
import com.algorithm.link.TreeNode;
import java.util.Stack;

public class MaxTreeCon {

    public static TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();     //申请栈存放节点
        TreeNode root = null;
        for (int i = 0; i <= A.length; i++) {
            TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE) //如果i==length,新建节点设置值为无穷大，否则值为A[i]
                    : new TreeNode(A[i]);
            while (!stack.isEmpty()) {        //如果栈不为空
                if (right.val > stack.peek().val) {			//如果新建节点的值比栈顶大
                    TreeNode nodeNow = stack.pop();          //临时保存栈顶节点并弹出
                    if (stack.isEmpty()) {                   //如果栈为空
                        right.left = nodeNow;                  //临时保存的栈顶的节点是当前新建节点的左子树
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val > right.val) {
                            right.left = nodeNow;                //新建节点的左子树为临时保存节点
                        } else {
                            left.right = nodeNow;                //当前栈顶的节点的右子树为新建节点
                        }
                    }
                } else
                    break;
            }
            stack.push(right);                          //将新建节点压入栈中
        }
        return stack.peek().left;
    }

    public static TreeNode maxTree2(int[] A) {
        // write your code here
        int len = A.length;
        TreeNode[] stk = new TreeNode[len];
        for (int i = 0; i < len; ++i)
            stk[i] = new TreeNode(0);			//新建节点
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            TreeNode tmp = new TreeNode(A[i]);
            while (cnt > 0 && A[i] > stk[cnt-1].val) {		//如果stk中的最后一个节点比新节点大
                tmp.left = stk[cnt-1];						//当前新节点的左子树为stk的最后一个节点
                cnt --;
            }
            if (cnt > 0)									//如果stk不为空
                stk[cnt - 1].right = tmp;					//将新节点设为stk最后一个节点的右子树
            stk[cnt++] = tmp;
        }
        return stk[0];
    }

    public static void main(String[] args) {
        int[] a= {1,2,3,4,5,6,7,87,8,9};
        TreeNode tree = maxTree(a);
        System.out.println(tree.toString());
    }
}
