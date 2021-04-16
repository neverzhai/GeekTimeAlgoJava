package geektime.algo.leecode.top100Medium;


/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-16 08:08
 * @description:
 */
public class ReverseList2 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next;

        for (int j = 0; j < right - left; j++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;

        }
        return dump.next;
    }
}