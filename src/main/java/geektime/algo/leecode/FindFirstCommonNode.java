package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-24 00:01
 * @description: 两个链表的第一个公共节点
 */
public class FindFirstCommonNode {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // method1: 先计算两个链表的长度, 然后长的先走几步


    // method2: 双指针法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;

        while (node1 != node2) {
            node1 = node1 != null ? node1.next: headB;
            node2 = node2 != null ? node2.next: headA;
        }

        return node1;
    }


}