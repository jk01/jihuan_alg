package com.algorithm;/**
 * Created by jihuan on 17/10/15.
 */

/**
 * Title: unique Binary Search Tree 不同的二叉查找树
 * Description: 该类的功能
 题目

 不同的二叉查找树

 给出 n，问由 1...n 为节点组成的不同的二叉查找树有多少种？

 样例
 给出n = 3，有5种不同形态的二叉查找树：

 1           3    3       2      1
 \         /    /       / \      \
 3      2     1       1   3      2
 /      /       \                  \
 2     1          2                  3
 */
public class Solution16 {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        int[] count = new int[n + 1];
        if( n==0 )
            return 1;
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                count[i] = count[i] + count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}
