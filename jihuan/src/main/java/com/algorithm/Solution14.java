package com.algorithm;

import java.util.Stack;

/**
 * Title: Simplify Path 简化路径
 * Description: 该类的功能
 题目
 简化路径
 给定一个文档(Unix-style)的完全路径，请进行路径简化。
 样例
 "/home/", => "/home"
 "/a/./b/../../c/", => "/c"
 挑战
 你是否考虑了 路径 = "/../" 的情况？
 在这种情况下，你需返回"/"。
 此外，路径中也可能包含双斜杠'/'，如 "/home//foo/"。
 在这种情况下，可忽略多余的斜杠，返回 "/home/foo"。
 解题
 linux 没碰过，真的表示不知道这个是什么鬼
 参考链接， 参考链接2
 Unix的path规则可以在这里了解：
 http://en.wikipedia.org/wiki/Path_(computing)
 路径简化的依据是：
 当遇到“/../"则需要返回上级目录，需检查上级目录是否为空。
 当遇到"/./"则表示是本级目录，无需做任何特殊操作。
 当遇到"//"则表示是本级目录，无需做任何操作。
 当遇到其他字符则表示是文件夹名，无需简化。
 当字符串是空或者遇到”/../”，则需要返回一个"/"。
 当遇见"/a//b"，则需要简化为"/a/b"。

 先将字符串依"/"分割出来，然后检查每个分割出来的字符串。
 当字符串为空或者为"."，不做任何操作。
 当字符串不为".."，则将字符串入栈。
 当字符串为"..", 则弹栈（返回上级目录）。
 这样栈内的字符就是答案，但是需要进行重新组合
 以“/”隔开组合
 */
public class Solution14 {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        if(path==null)
            return null;
        String[] p = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<p.length;i++){
            if(p[i].equals(".") || p[i].isEmpty()){
                continue;
            }else if(p[i].equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            }else{
                stack.push(p[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();


    }
}
