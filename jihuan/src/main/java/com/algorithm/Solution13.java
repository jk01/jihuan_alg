package com.algorithm;

/**
 * Title: Maximum Product Subarray 最大连续乘积子序列
 * Description: 该类的功能
 题目

 乘积最大子序列

 找出一个序列中乘积最大的连续子序列（至少包含一个数）。

 样例
 比如, 序列 [2,3,-2,4] 中乘积最大的子序列为 [2,3] ，其乘积为6。
 */
public class Solution13 {

    /**
     * 直接暴力求解
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null)
            return 0;
        int MAX = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<= n-1 ;i++){
            int pro = 1;
            for(int j = i;j< n;j++){
                pro *= nums[j];
                MAX = Math.max(MAX,pro);
            }
        }
        return MAX;
    }

    /**
     * 法二：利用动态规划
     个人感觉不好写，这里的数组有整数也有负数，某子数组乘积最大，有两种情况：1，负数*负数，2，正数*正数，所以要考虑两种情况，我只用第二种求解时候，发现了问题，毕竟许多负数成绩时候也可能取得整数的。
     负数当然要选取最小的负数了，正数要是最大的正数。
     maxLocal = A[0]
     minLocal = A[0]
     global = A[0]
     在变量A数组的过程中：
     maxLocal = max(maxLocal*A[i],A[i],minLocal*A[i])
     minLocal = min(maxLocal*A[i],A[i],minLocal*A[i])
     global = max(maxLocal,global)
     上面中间的A[i],是可能断了的情况，与之前求最大/小子数组的和是一个道理《乘以、加，减一个数，我们要选取我们需要的数咯》
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct2(int[] A) {
        // write your code here
        if(A == null || A.length ==0)
            return 0;
        int maxLocal = A[0];
        int minLocal = A[0];
        int global = A[0];
        for(int i=1;i< A.length; i++){
            int tmp = maxLocal;
            maxLocal = Math.max(Math.max(A[i]*maxLocal,A[i]),
                    A[i]*minLocal);
            minLocal = Math.min(Math.min(A[i]*tmp,A[i]),
                    A[i]*minLocal);
            global = Math.max(maxLocal,global);
        }
        return global;

    }
}
