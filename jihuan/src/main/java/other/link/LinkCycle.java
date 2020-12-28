package other.link;

public class LinkCycle {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val =val;
            this.next = null;
        }
    }
    public static boolean hasCycle(ListNode head) {
        // write your code here
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null &&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;

    }
}
