package com.algorithm.link;

public class QueueList {
    public ListNode first, last;

    public QueueList() {
        first = last = null;
        // do initialize if necessary
    }

    public void enqueue(int item) {
        // Write your code here
        if (first == null) {
            last = new ListNode(item);
            first = last;
        } else {
            last.next = new ListNode(item);
            last = last.next;
        }
    }

    public int dequeue() {
        // Write your code here
        if (first != null) {
            int item = first.val;
            first = first.next;
            return item;
        }
        return -1;
    }
}
