package com.algorithm;

/**
 * Title: find the missing number 寻找缺失的数
 * Description: 该类的功能
 题目

 寻找缺失的数

 给出一个包含 0 .. N 中 N 个数的序列，找出0 .. N 中没有出现在序列中的那个数。

 样例
 N = 4 且序列为 [0, 1, 3] 时，缺失的数为2。

 注意
 可以改变序列中数的位置。

 挑战
 在数组上原地完成，使用O(1)的额外空间和O(N)的时间。

 解题

 */
public class Solution19 {

    /**
     * 重新定义一个数组存放排序后的数，空间复杂度和时间复杂度都是O(N)
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        boolean[] A = new boolean[nums.length +1];
        for(int i = 0;i<nums.length; i++){
            A[nums[i]] = true;
        }
        int n = 0;
        for(int i = 0;i< A.length ;i++){
            if(A[i] == false){
                n = i;
                break;
            }
        }

        return n;
    }

    /**
     * 在下面的挑战中，说可以在原始数组上面操作，如何在原始数组上面操作？空间复杂度并且是O(1)
     i^i = 0 一个数自身的异或等于0
     这个可以空间复杂可以是O(1),就有下面的代码了
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing2(int[] nums) {
        // write your code here
        int res = 0;
        for( int i =0;i< nums.length ;i++){
            res = res ^ nums[i] ^ i;
        }
        res = res^(nums.length);
        return res;
    }
}
