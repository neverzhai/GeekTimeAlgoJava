package geektime.algo.mianshi;

import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-24 09:49
 * @description: 两个链表的第一个公共节点
 */
public class FirstCommonNode {

    class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        // 计算二者长度
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        int diff = len1 - len2;

        ListNode headLong = head1;
        ListNode headShort = head2;

        if (diff < 0) {
            diff = len2 - len1;
            headLong = head2;
            headShort = head1;
        }

        for (int index =0; index < diff; index++) {
            headLong = headLong.next;
        }

        while (headLong != null && headShort != null && headLong != headShort) {
            headLong = headLong.next;
            headShort = headShort.next;
        }

        return headLong;

    }

    private int getLength(ListNode head1) {
        int length = 0;
        while (head1 != null) {

            length++;
            head1= head1.next;
        }
        return length;
    }
}
