package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: Implement Trie
 * Description: 该类的功能
 题目
 Implement Trie
 Implement a trie with insert, search, and startsWith methods.
 样例
 注意
 You may assume that all inputs are consist of lowercase letters a-z.
 解题
 Trie，字典树，又称单词查找树、前缀树，是一种哈希树的变种。应用于字符串的统计与排序，经常被搜索引擎系统用于文本词频统计。
 性质：
 1.根节点不包含字符，除根节点外的每一个节点都只包含一个字符。
 2.从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
 3.每个节点的所有子节点包含的字符都不相同。
 优点是查询快。对于长度为m的键值，最坏情况下只需花费O(m)的时间；而BST需要O(m log n)的时间。
 程序来源链接

 1.理解Trie 字典树很重要

 2.定义TrieNode节点类很重要
 */
public class Solution20 {
    private TrieNode root = null;

    public Solution20() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character,TrieNode> children = root.children;
        for(int i = 0;i< word.length() ;i++){
            char c = word.charAt(i);
            TrieNode t = null;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c,t);
            }
            children = t.children;
            if(i == word.length() - 1)
                t.leaf = true;
        }

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return t!=null && t.leaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String word){
        Map<Character ,TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0;i< word.length() ;i++){
            char c = word.charAt(i);
            if(!children.containsKey(c))
                return null;
            t = children.get(c);
            children = t.children;
        }
        return t;
    }
}
class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean leaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode(char c) {
        this.c = c;
    }
    public TrieNode() {}
}