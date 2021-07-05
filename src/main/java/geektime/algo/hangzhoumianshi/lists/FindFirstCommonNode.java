package geektime.algo.hangzhoumianshi.lists;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-05 10:17
 * @description: 查找两个链表的第一个公共节点
 */
public class FindFirstCommonNode {

    // method1: 先计算两个链表的长度, 然后长的先走几步
    public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        int l1 = getLength(head1);
        int l2 = getLength(head2);
        int maxDiff = 0;
        if (l1 > l2) {
            maxDiff = l1 - l2;
            for (int i = 0; i < maxDiff; i++) {
                head1 = head1.next;
            }
        } else {
            maxDiff = l2 - l1;
            for (int i = 0; i < maxDiff; i++) {
                head2 = head2.next;
            }
        }

        while (head1 != null && head2 != null) {
            if (head1.equals(head2)) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;

    }

    private int getLength(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }


    // method2: 双指针法
    public ListNode FindFirstCommonNode1(ListNode head1, ListNode head2) {
        ListNode node1 = head1;
        ListNode node2 = head2;

        while (node1 != node2) {
            node1 = node1 != null ? node1.next : head2;
            node2 = node2 != null ? node2.next : head1;
        }

        return node1;
    }

}