package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-18 23:22
 * @description: 两两交换链表中的节点
 */
public class swapPairs {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 递归方法
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 迭代方法
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dump = new ListNode();
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