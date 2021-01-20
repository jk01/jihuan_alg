package com.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class StrWordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
        return dfs(s, dict, 0);
    }

    /**
     * 递归的定义
     * 判断字符串s[start: ]能否通过wordDict中的单词组成
     **/
    public static boolean dfs(String s, Set<String> dict, int now) {
        // 递归的出口
        if (now == s.length()) {
            return true;
        }

        // 递归的拆解，枚举下一个字符串的长度len
        for (int len = 1; now + len <= s.length(); len++) {
            // 判断s[now: now + len]是否满足条件
            if (dict.contains(s.substring(now, now + len)) && dfs(s, dict, now + len)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str= "helloworld";
        Set<String> dict = new HashSet<>();
        dict.add("dsfdsf");
        dict.add("he");
        dict.add("dsfdsf");
        dict.add("llo");
        dict.add("w");
        dict.add("or");
        dict.add("ld");
        System.out.println(wordBreak(str,dict));

    }
}
