package com.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLengthTree {
    int head[] = new int[100010];

    class node {
        int to;
        int next;
        int dis;

        public node(int to, int next, int dis) {
            this.to = to;
            this.next = next;
            this.dis = dis;
        }
    }

    node edge[] = new node[500010];

    int num = 0;
    int dis[] = new int[100010];
    int record[] = new int[100010];

    void add(int u, int v, int w) {
        edge[num] = new node(v, head[u], w);
        head[u] = num++;
    }

    int bfs(int s, boolean flag) {
        int i, t, w, tmpl = 0, tmpt = s;
        for (i = 0; i < 100010; i++) {
            record[i] = -1;
        }
        record[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            int p = q.poll();
            for (i = head[p]; i != -1; i = edge[i].next) {
                t = edge[i].to;
                w = edge[i].dis;
                if (record[t] == -1) {
                    record[t] = record[p] + w;
                    if (record[t] > tmpl) {
                        tmpl = record[t];
                        tmpt = t;
                    }
                    q.offer(t);
                }
            }
        }
        return flag ? tmpl : tmpt;
    }

    public int longestPath(int n, int[] starts, int[] ends, int[] lens) {
        // Write your code here
        for (int i = 0; i < n; i++) {
            head[i] = -1;
        }
        for (int i = 0; i < n - 1; i++) {
            add(starts[i], ends[i], lens[i]);
            add(ends[i], starts[i], lens[i]);
        }
        return bfs(bfs(0, false), true);
    }
}
