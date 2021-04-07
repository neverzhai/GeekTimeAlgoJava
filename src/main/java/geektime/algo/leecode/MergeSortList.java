package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-07 08:51
 * @description: 使用归并排序方法进行列表排序
 */
public class MergeSortList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        ListNode head1 = sortList(head);
        ListNode head2 = sortList(newHead);
        ListNode result = merge(head1, head2);

       return result;
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
