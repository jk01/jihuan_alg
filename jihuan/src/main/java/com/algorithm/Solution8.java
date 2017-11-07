package com.algorithm;

import java.util.ArrayList;

/**
 * Title: permutations 全排列
 * Description: 该类的功能
 题目

 全排列
 给定一个数字列表，返回其所有可能的排列。
 您在真实的面试中是否遇到过这个题？
 Yes
 样例
 给出一个列表[1,2,3]，其全排列为：
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 挑战
 使用递归和非递归分别解决。
 解题
 深度优先遍历，找到一个保存一个，自己没有写出来，参考九章中的程序
 * @author jihuan
 * @create 2017-10-15 22:03
 * @version: 1.0
 */
public class Solution8 {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() ==0 )
            return result;
        helper(nums,list,result);
        return result;
    }
    public static void helper(ArrayList<Integer> nums,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res){
        if(list.size() == nums.size()){
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i=0;i< nums.size();i++){
            if(list.contains( nums.get(i))){
                continue;
            }
            list.add(nums.get(i));
            helper(nums,list,res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        ArrayList<ArrayList<Integer>> result=permute(list);
        for(ArrayList<Integer> list1:result){
            System.out.println(list1.toString());
        }
    }
}
