package geektime.algo.hangzhoumianshi.lists;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-05 11:23
 * @description: 合并两个有序链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ?  l2 : l1;

        return dummy.next;
    }
}