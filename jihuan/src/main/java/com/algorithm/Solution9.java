package com.algorithm;

import java.util.Stack;

/**
 * Title: Min stack 最小栈
 * Description:
 题目
 带最小值操作的栈
 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
 解题
 可以定义一个数组或者其他的存储最小值，第i个元素，表示栈中前i个元素的最小值。
 定义两个ArrayList来存储栈，一个ArrayList存储当前栈中的元素，一个ArrayList存储最小栈，并且其第i个元素表示栈中前i个元素的最小值，这样两个栈的长度是始终一样的
 入栈：最小栈需要加入的元素是 当前要入的元素和list中最后一个元素的最小值
 出栈：最小栈也要出栈的，不需要进行比较，直接出栈
 获取最小值：就是去栈顶元素的，直接取出list 中最后一个元素就好了
 取栈顶元素：直接取
 Java Code  //todo
 上面程序中最小栈元素保存的元素有重读，可以优化下。
 九章中看到了另外一种解法,用两个栈了存储两个栈
 一种程序如下，最小栈中重复数据减少了。
 * @author jihuan
 * @create 2017-10-15 22:04
 * @version: 1.0
 */
public class Solution9 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public Solution9() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if( minStack.isEmpty()){
            minStack.push(number);
        }else if( number <= minStack.peek()){
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        int p = stack.pop();
        if( p == minStack.peek())
            minStack.pop();
        return p;
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
