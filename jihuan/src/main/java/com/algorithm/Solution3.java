package com.algorithm;

/**
 * Title: 类的主题（开发人员填写）
 * Description: 该类的功能
 题目
 数组划分
 给出一个整数数组nums和一个整数k。划分数组（即移动数组nums中的元素），使得：
 所有小于k的元素移到左边
 所有大于等于k的元素移到右边
 返回数组划分的位置，即数组中第一个位置i，满足nums[i]大于等于k。
 您在真实的面试中是否遇到过这个题？
 Yes
 样例
 给出数组nums=[3,2,2,1]和 k=2，返回 1
 注意
 你应该真正的划分数组nums，而不仅仅只是计算比k小的整数数，如果数组nums中的所有元素都比k小，则返回nums.length。
 挑战
 要求在原地使用O(n)的时间复杂度来划分数组
 解题
 快速排序，搞了好久，中间的那个值一直找不到，然后就遍历数组找了。
 */
public class Solution3 {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        //write your code here
        if(nums.length==0)
            return 0;
        int p = partition(nums,0,nums.length-1,k);
        return p;

    }
    public int partition(int[] nums,int left,int right,int k){
        int i = left;
        int j = right;
        while(i<=j){
            while(i<=j&&nums[j] >=k) j--;
            while(i<=j&& nums[i]<k) i++;
            if(i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
                i++;
            }
        }
        return i;
    }

    public int partition2(int[] nums,int l,int r ,int d){
        //todo

        return l;
    }
}
