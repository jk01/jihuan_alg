package com.algorithm.tree;

public class kEmptySlotsTree {
    public int kEmptySlots(int[] flowers, int k) {
        // Write your code here
        int[] days =  new int[flowers.length];
        for(int i=0; i < flowers.length; i++){    //存储i位置花的开放时间
            days[flowers[i] - 1] = i + 1;
        }
        int left = 0;
        int right = k + 1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; right < days.length; i++){	//当i位置的开放时间较早
            if(days[i] < days[left] || days[i] <= days[right]){
                if(i == right){			//i移动到right，说明当前区间中没有花的开放时间早于左右端点
                    res = Math.min(res, Math.max(days[left], days[right]));  //左右两端点选择较晚开放的，然后再选择每次更新最下答案
                }
                left = i; 				//更新区间端点
                right = k + 1 + i;
            }
        }
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return res;
        }
    }
}
