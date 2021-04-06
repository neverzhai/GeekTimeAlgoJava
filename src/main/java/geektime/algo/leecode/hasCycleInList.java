package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-18 23:44
 * @description:
 */
public class hasCycleInList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}