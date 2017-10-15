package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 递归打印数字
 * Description: 该类的功能
 题目

 用递归打印数字

 用递归的方法找到从1到最大的N位整数。

 样例
 给出 N = 1, 返回[1,2,3,4,5,6,7,8,9].

 给出 N = 2, 返回[1,2,3,4,5,6,7,8,9,10,11,...,99].

 注意
 用下面这种方式去递归其实很容易：

 recursion(i) {
 if i > largest number:
 return
 results.add(i)
 recursion(i + 1)
 }
 但是这种方式会耗费很多的递归空间，导致堆栈溢出。你能够用其他的方式来递归使得递归的深度最多只有 N 层么？

 挑战
 用递归完成，而非循环的方式

 解题

 非递归最简单了，先求出最大的n位数N，然后顺序遍历求解
 */
public class Solution18 {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        int N = 1;
        for(int i = 1;i<=n;i++){
            N = N*10;
        }
        N = N - 1;
        List<Integer> result = new ArrayList<Integer>();
        getPrint(1,N,result);
        return result;
    }
    public void getPrint(int i,int N,List<Integer> result ){
        if(i>N)
            return ;
        result.add(i);
        getPrint(i+1,N,result);
    }
}
