package com.algorithm.link;

import java.util.ArrayList;
import java.util.List;

public class LinkToArray {
    public List<Integer> toArrayList(ListNode head) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        //遍历链表，并将ListNode的val存储在数组中
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }
}
