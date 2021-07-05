package geektime.algo.hangzhoumianshi.lists;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-05 11:34
 * @description: 链表排序--- 使用归并排序对链表进行排序
 */
public class SortInList {

    public ListNode sortInList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next; // 注意这个地方一定是head.next, 否则在只有两个节点时会死循环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nHead = slow.next;
        slow.next = null;
        ListNode h1 = sortInList(head);
        ListNode h2 = sortInList(nHead);
        ListNode result = mergeTwoLists(h1, h2);

        return result;
    }

    private ListNode mergeTwoLists (ListNode l1, ListNode l2) {
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