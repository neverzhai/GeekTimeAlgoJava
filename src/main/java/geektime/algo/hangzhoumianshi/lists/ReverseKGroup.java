package geektime.algo.hangzhoumianshi.lists;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-06 09:11
 * @description: 链表K个一组进行翻转
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode connect = null;
        ListNode start = head;

        while (start != null) {
            int count = 0;
            ListNode end = start;
            while(++count != k) {
                end = end.next;
                if (end == null) {
                    return head;
                }
            }

            ListNode nextListNode = end.next;
            ListNode newHead = reverseList(start, end);
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

    private ListNode reverseList(ListNode curr, ListNode end) {
        ListNode pre = null;
        while( pre != end) {
            ListNode next  = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}