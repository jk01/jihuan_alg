package com.algorithm.string;

public class MaxLenNoDup {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int from = 0, to = 1, length = 1, maxLength = 1;
        // to遍历直到字符串末尾
        String maxStr = "";
        while (to < s.length()){
            String str = s.substring(from, to);
            int site = s.substring(from, to).indexOf(s.charAt(to));
            if (site != -1){
                // to指向的字符已存在
                length = to - from;
                if (length > maxLength){
                    maxLength = length;
                    maxStr = str;
                }
                // from 跳转到site+1的位置
                from = from + site + 1;
            }
            to++;
        }
        // 处理最后一个子串
        if (to - from > maxLength) {
            maxLength = to - from;
        }
        System.out.println(maxStr);
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abacdsgdgdfg";
        int a=lengthOfLongestSubstring(str);
        System.out.println(a);
    }
}
