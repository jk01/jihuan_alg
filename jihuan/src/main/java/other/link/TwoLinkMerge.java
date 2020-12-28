package other.link;

public class TwoLinkMerge {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //新链表，记录合并
        ListNode node = null;
        //比较链表值
        if (l1.val < l2.val) {
            //存储较小的
            node = l1;
            //递归，移动指针
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            //存储较小的
            node = l2;
            //递归，移动指针
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val =val;
            this.next = null;
        }
    }
}
