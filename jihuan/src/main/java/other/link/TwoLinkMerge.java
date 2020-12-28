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

    //非递归，占用内存小
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //记录合并链表，初始化
        ListNode newNode = new ListNode(-1);
        //合并链表的指针
        ListNode node = newNode;
        while (l1 != null && l2 != null) {
            //比较链表值，存储较小的，然后移动指针
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            // 将指针移动到合并后链表的结尾
            node = node.next;
        }
        // 如果第一个链表的元素未处理完，将其接到合并链表的最后一个结点之后
        if (l1 != null) {
            node.next = l1;
        }
        // 如果第二个链表的元素未处理完，将其接到合并链表的最后一个结点之后
        if (l2 != null) {
            node.next = l2;
        }
        return newNode.next;
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
