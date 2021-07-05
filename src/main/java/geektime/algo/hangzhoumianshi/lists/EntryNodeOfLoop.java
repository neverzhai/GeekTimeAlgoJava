package geektime.algo.hangzhoumianshi.lists;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-05 09:58
 * @description: 链表中环的入口节点
 */
public class EntryNodeOfLoop {

    // 快慢指针法
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        ListNode intect = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.equals(slow)) {
                intect = fast;
                break;
            }
        }
        if (intect == null) {
            return null;
        }

        ListNode part1 = pHead;
        ListNode part2 = intect;
        while (part1 != part2) {
            part1 = part1.next;
            part2 = part2.next;
        }
        return part1;
    }
}