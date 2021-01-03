package com.algorithm.string;

public class LongestCommonPrefixS {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if( j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] arr = {"asd","asdw","afff","as"};
        String result = longestCommonPrefix(arr);
        System.out.println(result);
    }
}
