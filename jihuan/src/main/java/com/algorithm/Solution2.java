package com.algorithm;

import java.util.HashMap;

/**
 * Title: 类的主题（开发人员填写）
 题目
 最小子串覆盖
 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的子串。
 样例
 给出source = "ADOBECODEBANC"，target = "ABC" 满足要求的解  "BANC"
 注意
 如果在source中没有这样的子串，返回""，如果有多个这样的子串，返回起始位置最小的子串。
 挑战
 要求时间复杂度为O(n)
 说明
 在答案的子串中的字母在目标字符串中是否需要具有相同的顺序？
 ——不需要。
 解题
 参考：
 定义两个字典：tgt 、map
 tgt统计target中每个字符出现的次数
 map统计target和source出现的公共字符个数
 再检测当tgt中所以的字符和map中的字符个数都匹配的时候就是一个子串了，再找出最小的子串就好了，程序中left值用来定义子串的右边界，要好好理解
 */
public class Solution2 {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public static String minWindow(String source, String target) {
        // write your code
        int len1 = source.length();
        int len2 = target.length();
        if(len1 < len2)
            return "";
        String result = "";
        // 统计target 中各个字符串出现的次数
        HashMap<Character,Integer> tgt = new HashMap<Character,Integer>();
        for(int i=0;i<len2;i++){
            char c = target.charAt(i);
            if(tgt.containsKey(c)){
                tgt.put(c,tgt.get(c)+1);
            }else{
                tgt.put(c,1);
            }
        }
        // 存放公共字符
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int left = 0;
        int minLen = len1+1;
        int count =0;
        for(int i=0;i<len1;i++){
            char c = source.charAt(i);
            if(tgt.containsKey(c)){
                if(map.containsKey(c)){
                    if(map.get(c)<tgt.get(c)){
                        count++;
                    }
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                    count++;
                }
            }
            // 说明是一个子串 去除left无效字符
            if(count == len2){
                char sc = source.charAt(left);
                while(!map.containsKey(sc) || map.get(sc) > tgt.get(sc)){
                    if(map.containsKey(sc) && map.get(sc) > tgt.get(sc))
                        map.put(sc,map.get(sc) - 1);
                    left++;
                    sc = source.charAt(left);
                }
                // 找到最小子串
                if( i - left + 1 < minLen){
                    result = source.substring(left,i + 1);
                    minLen = i - left + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String source = "ADBCDDFDOABNCODEBANC",target = "ABC";
        String result=minWindow(source,target);
        System.out.println(result);
        String a=source.substring(1,2);
        System.out.println(a);
    }
}
