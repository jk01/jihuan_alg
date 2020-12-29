package com.algorithm.link;

import java.util.ArrayList;
import java.util.List;

public class MergeSortLink {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeSortLink sortLink = new MergeSortLink();
        List<ListNode> listNodeList = new ArrayList<ListNode>();
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(2);
        a1.next =a2;
        a2.next =a3;
        a3.next =a4;
        listNodeList.add(a1);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(7);
        b1.next = b2;
        listNodeList.add(b1);
        ListNode result = sortLink.mergeKLists(listNodeList);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
        System.out.println();

    }
}
