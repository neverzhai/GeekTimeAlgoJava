package geektime.algo.hangzhoumianshi.lists;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-06 09:13
 * @description: 删除有序链表中的重复元素
 */
public class RemoveDuplicateInList {

    // 使每个元素只保留一次
    public ListNode deleteDuplicates1 (ListNode head) {
        // write code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = head;
        while (second != null) {
            if (first.val == second.val) {
                first.next = second.next;
                second = second.next;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        return dummy.next;
    }

    // 2. 只保留出现一次的元素
    public ListNode deleteDuplicates (ListNode head) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode first = dump;
        ListNode second  = head;

        while (second != null) {
            while (second.next !=null && second.val == second.next.val) {
                second = second.next;
            }
            if (first.next == second) {
                first = first.next;
            } else {
                first.next = second.next;
            }
            second = second.next;
        }
        return dump.next;
    }

}