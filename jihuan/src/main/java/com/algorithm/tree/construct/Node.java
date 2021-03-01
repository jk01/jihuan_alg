package com.algorithm.tree.construct;

public class Node {
    public int key; // 关键字

    public double value; // 值

    //指向节点的子节点的引用；
    public Node leftChild;
    public Node rightChild;

    public void displayNode()
    {
        System.out.print('{');
        System.out.print(key);
        System.out.print(", ");
        System.out.print(value);
        System.out.print("} ");
    }
}
