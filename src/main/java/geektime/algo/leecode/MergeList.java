package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-07 09:45
 * @description: 合并两个有序链表
 */
public class MergeList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode merge(ListNode head1, ListNode head2) {

        ListNode dump = new ListNode(0);
        ListNode curr = dump;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        curr.next = head1 == null ? head2 : head1;

        return dump.next;
    }
}
