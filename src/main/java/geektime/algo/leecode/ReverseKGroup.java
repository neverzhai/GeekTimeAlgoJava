package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-21 09:28
 * @description:
 */
public class ReverseKGroup {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode connect = null;
            ListNode start = head;
            while (start != null) {
                int count = 0;
                ListNode end = start;
                while (++count != k) {
                    end = end.next;
                    if (end == null) {
                        return head;
                    }
                }
                ListNode nextListNode = end.next;
                ListNode newHead = reverseListNode(start, end);
                if (connect != null) {
                    connect.next = newHead;
                } else {
                    head = newHead;
                }
                start.next = nextListNode;
                connect = start;
                start = nextListNode;
            }
            return head;
        }

        private ListNode reverseListNode(ListNode start, ListNode end) {
            ListNode tmp = null;
            while (tmp != end) {
                ListNode next = start.next;
                start.next = tmp;
                tmp = start;
                start = next;
            }
            return tmp;
        }

}