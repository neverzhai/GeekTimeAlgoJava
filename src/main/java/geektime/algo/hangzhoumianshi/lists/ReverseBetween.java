package geektime.algo.hangzhoumianshi.lists;


/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-06 08:28
 * @description: 链表内指定区间翻转
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

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

        return dummy.next;
    }
}