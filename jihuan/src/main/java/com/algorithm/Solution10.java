package com.algorithm;
/**
 * Title: kth-largest-element 第k大元素
 * Description: 该类的功能
 题目
 第k大元素
 在数组中找到第k大的元素
 样例
 给出数组[9,3,2,4,8]，第三大的元素是4
 给出数组 [1,2,3,4,5]，第一大的元素是5，第二大的元素是4，第三大的元素是3，以此类推
 注意
 你可以交换数组中的元素的位置
 挑战
 要求时间复杂度为O(n），空间复杂度为O(1）
 解题
 理论快速排序的思想，每次都减半，这个时间复杂度也是O(N)，至于为什么就不知道了
 * @author jihuan
 * @create 2017-10-15 22:07
 * @version: 1.0
 */
public class Solution10 {
    /*
    * @param k : description of k
    * @param nums : array of nums
    * @return: description of return
    */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return quickSort(nums,0,nums.length-1,k);

    }
    public int quickSort(int[] nums,int left,int right,int k){
        int i = left;
        int j = right;
        int tmp = nums[i];
        while(i<j){
            while(i<j && tmp>=nums[j]) j--;
            if(i<j){
                nums[i]=nums[j];
                i++;
            }
            while(i<j && tmp<nums[i]) i++;
            if(i<j){
                nums[j]=nums[i];
                j--;
            }

        }
        if(i == k -1){
            return tmp;
        }else if(i< k-1){
            return quickSort(nums,i+1,right,k);
        }else{
            return quickSort(nums,left,i-1,k);
        }
    }
}
