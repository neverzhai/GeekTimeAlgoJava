package geektime.algo.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-18 23:51
 * @description:
 */
public class detectCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode intect = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                intect = fast;
                break;
            }
        }

        if (intect == null) {
            return null;
        }

        ListNode par1 = head;
        ListNode par2 = intect;
        while (par1 != par2) {
            par1 = par1.next;
            par2 = par2.next;
        }
        return par1;

    }

    // 哈希表
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode pos = head;
            Set<ListNode> visited = new HashSet<ListNode>();
            while (pos != null) {
                if (visited.contains(pos)) {
                    return pos;
                } else {
                    visited.add(pos);
                }
                pos = pos.next;
            }
            return null;
        }
    }
}