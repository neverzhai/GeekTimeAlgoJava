package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-15 21:02
 * @description: 删除链表中重复元素
 */
public class RemoveDuplicateInList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode test(ListNode head) {
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node = test(node1);

    }
}