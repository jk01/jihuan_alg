package com.algorithm.link;

public class BlockNumberLink {
    /**
     * @param head: the given doubly linked list
     * @param nodes: the given nodes array
     * @return: the number of blocks in the given array
     */
    public int[] fa = new int [500];
    public int find(int x) {
        if(fa[x] == x)
            return x;
        return fa[x] = find(fa[x]);
    }
    public void merge(int x,int y) {
        x = find(x);
        y = find(y);
        fa[x] = y;

    }
    public int blockNumber(DoublyListNode head, int[] nodes) {
        // write your code here
        if(head == null)
            return 0;
        boolean [] vis = new boolean [1000];
        int res = 0;
        for(int i = 0; i < nodes.length; i++) {
            vis[nodes[i]] = true;
        }
        for(int i = 1; i <= 300 ;i++) {
            fa[i] = i;
        }
        DoublyListNode p = head;
        while(p.next != null) {
            if(vis[p.val] == true && vis[p.next.val] == true) {
                merge(p.val,p.next.val);
            }
            p = p.next;
        }
        for(int i = 0; i < nodes.length; i++) {
            if(find(nodes[i]) == nodes[i])
                res++;
        }
        return res;
    }
}
