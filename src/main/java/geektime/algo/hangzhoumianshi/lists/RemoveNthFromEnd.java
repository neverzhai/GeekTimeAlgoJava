package geektime.algo.hangzhoumianshi.lists;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-05 10:48
 * @description: 删除链表的倒数第n个节点
 */
public class RemoveNthFromEnd {

    // method1 先计算链表长度l， 然后倒数第n个节点， 即为正向的l-n
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int l = getLength(head);
        ListNode curr = dummy;
        for (int i = 0; i < l - n; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }

    // method2: 两次遍历链表--- 双指针
    public ListNode removeNthFromEnd1(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
        dummy.next = head;
       ListNode fast = dummy;
       ListNode slow = dummy;
       for (int i = 0; i < n; i++) {
           fast = fast.next;
       }

       while (fast.next != null) {
           fast = fast.next;
           slow = slow.next;
       }
       slow.next = slow.next.next;

       return dummy.next;
    }
}