package geektime.algo.hangzhoumianshi.lists;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-06 09:12
 * @description: 链表元素两两一组进行翻转
 */
public class Reverse2Group {
    // 迭代方法
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode temp = dump;

        while (temp.next != null && temp.next.next != null) {
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            temp.next = second;
            first.next = second.next;
            second.next = first;
            temp = first;
        }
        return dump.next;
    }
}