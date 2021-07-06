package geektime.algo.hangzhoumianshi.lists;

import java.util.ArrayList;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-06 10:04
 * @description:  合并K个有序链表
 */
public class MergeKLists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return merge(lists, 0, lists.size() - 1);
    }

    private ListNode merge(ArrayList<ListNode> lists, int left, int right) {
        if (left == right) {
            return lists.get(left);
        }
        if (left > right) {
            return null;
        }

        int mid = left + (right -left) / 2;
        return mergeTwoLists(merge(lists,left, mid), merge(lists, mid+1, right));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

}