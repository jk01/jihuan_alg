package com.algorithm;

import java.util.Stack;

/**
 * Title: Evaluate Reverse Polish notation逆波兰表达式求值
 * Description: 该类的功能
 题目

 逆波兰表达式求值

 在逆波兰表达法中，其有效的运算符号包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰计数表达。
 样例
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 说明
 什么是逆波兰表达式？

 http://en.wikipedia.org/wiki/Reverse_Polish_notation
 解题

 利用栈的解题

 当是数字的时候入栈，当不是数字的时候连续两次出栈，对出栈的数据进行运算，运算结果再入栈

 如何判定是数字？
 根据正则还是比较简单的
 str.matches("\\d+") == true
 需要注意的是：是负数的情况
 str.substring(0,1).equals("-")&& str.substring(1,str.length()).matches("\\d+") == true
 我是先判定第一个字符是“-” ,再判定是否是数字
 后面就是对于四则运行就简单，注意非法字符，和除0的情况，我是直接返回最大值。
 还有个要注 意的是当在运算的过程中栈空了，说明输入的不是有效的逆波兰表达式

 */
public class Solution15 {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        if(tokens == null)
            return 0;
        if(tokens.length == 1)
            return Integer.valueOf(tokens[0]);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =0;i< tokens.length ;i++){
            String str = tokens[i];

            if(str.matches("\\d+") == true ||
                    str.substring(0,1).equals("-")&&str.substring(1,str.length()).matches("\\d+") == true){
                int num = Integer.valueOf(str);
                stack.push(num);
            }else{
                if(stack.empty()){
                    System.out.println("the stack is empty");
                    return -1;
                }
                int num2 = stack.pop();
                int num1 = stack.pop();

                int res = calculate(num1,num2,str);
                stack.push(res);
            }
        }
        return stack.pop();
    }
    public int calculate(int num1,int num2,String symbol){
        if(symbol.equals("+"))
            return num1+ num2;
        if(symbol.equals("-"))
            return num1 - num2;
        if(symbol.equals("*"))
            return num1*num2;
        if(symbol.equals("/")){
            if(num2!=0){
                return num1/num2;
            }else{
                return Integer.MAX_VALUE;
            }
        }else{
            return Integer.MAX_VALUE;
        }
    }
}
