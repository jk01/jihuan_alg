package com.algorithm.link;

import java.util.ArrayList;

public class StackLink1 {

    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity;
    // @param capacity an inetger, capacity of sub stack
    public StackLink1(int capacity) {
        // do initialization if necessary
        this.capacity = capacity;
    }
    public Stack getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    // @param v an integer
    public void push(int v) {
        // Write your code here
        Stack last = getLastStack();
        if (last != null && !last.isAtCapacity()) { // add to last stack
            last.push(v);
        } else { // must create new stack
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    // @return an integer
    public int pop() {
        // Write your code here
        Stack last = getLastStack();
        int v = last.pop();
        if (last.size == 0) stacks.remove(stacks.size() - 1);
        return v;
    }
}

class Stack {
    private int capacity;
    public Node top, bottom;
    public int size = 0;
    public Stack(int capacity) { this.capacity = capacity; }
    public boolean isAtCapacity() { return capacity == size; }
    public void join(Node above, Node below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public boolean push(int v) {
        if (size >= capacity) return false;
        size++;
        Node n = new Node(v);
        if (size == 1) bottom = n;
        join(n, top);
        top = n;
        return true;
    }

    public int pop() {
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() { return size == 0; }
    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }
}

class Node {
    public Node below, above;
    public int value;
    Node(int v) {
        this.value = v;
    }

}
