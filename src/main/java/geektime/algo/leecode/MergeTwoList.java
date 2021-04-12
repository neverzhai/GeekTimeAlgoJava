package geektime.algo.leecode;



/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-23 23:05
 * @description:
 */
public class MergeTwoList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        ListNode dump = new ListNode(0);
        ListNode curr = dump;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1  = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;

        return dump.next;
    }
}