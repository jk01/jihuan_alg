package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Title: lintcode：subSets 子集
 * Description:
 * 题目
 子集
 给定一个含不同整数的集合，返回其所有的子集
 样例
 如果 S = [1,2,3]，有如下的解：
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 注意
 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 挑战
 你可以同时用递归与非递归的方式解决么？
 解题
 根据上面求排列的思想很类似，还是深度优先遍历。由于输出每个子集需要升序，所以要先对数组进行排序。求出所以的子集，也就是求出所以的组合方式 + 空集
 问题转化为求组合方式的问题
 参考链接不仅要考虑起始位置，还需要考虑长度，这样才是组合 C(n,k)，由于我只想到要考虑起始位置，而长度问题在程序中增加，一直没有解决问题

 *
 * @author jihuan
 * @create 2017-10-15 22:00
 * @version: 1.0
 */
public class Solution6 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length ==0)
            return res;
        Arrays.sort(nums);
        helper(nums,0,list,res);

        return res;
    }
    public static  void helper(int[] nums,int start, ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList<Integer>(list));
        for(int i=start;i< nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(nums,i+1,list,res);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        ArrayList<ArrayList<Integer>> result=subsets(nums);
        for(ArrayList<Integer> list:result){
            System.out.println(list.toString());
        }
    }
}
