package com.algorithm;

import java.util.ArrayList;

/**
 * Title: permutations II 重复数据的全排列
 * Description: 该类的功能
 题目
 带重复元素的排列
 给出一个具有重复数字的列表，找出列表所有不同的排列。
 样例
 给出列表 [1,2,2]，不同的排列有：
 [
 [1,2,2],
 [2,1,2],
 [2,2,1]
 ]
 挑战
 使用递归和非递归分别完成该题。
 解题
 和上面差不多，增加判断res中是否已经存在该排列的语句，这种方法不是很好，但是竟然也可以通过
 * @author jihuan
 * @create 2017-10-15 22:02
 * @version: 1.0
 */
public class Solution7 {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums ==null || nums.size() ==0)
            return res;
        boolean[] used = new boolean[nums.size()];
        helper(nums,list,res,used);
        return res;
    }
    public void helper(ArrayList<Integer> nums,ArrayList<Integer> list,
                       ArrayList<ArrayList<Integer>> res,boolean[] used){
        if(nums.size() == list.size()){
            ArrayList<Integer> list2 =new ArrayList<Integer>(list);
            if(!res.contains(list2))
                res.add(list2);
            return;
        }
        for(int i=0;i< nums.size();i++){
            if(!used[i]){
                used[i] = true;
                list.add(nums.get(i));
                helper(nums,list,res,used);
                list.remove(list.size()-1);
                used[i]= false;
            }
        }
    }
}
