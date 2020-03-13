package geektime.algo.linkedList;

import java.util.HashSet;
import java.util.List;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 */

public class LinkedListAlgo {

    //单链表反转
    public static ListNode reverse(ListNode head) {
        ListNode tmp = null;
        ListNode cur = head;
        ListNode pre = null;

        while(cur != null) {
            tmp = cur.next;
            cur.next  = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 链表中环的检测
    // Set集合的方式
    public static boolean checkCircle1(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<ListNode>();
        while (head != null) {
            if (nodes.contains(head)){
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    // 链表中环的检测
    // 快慢指针
    public static boolean checkCircle2(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if(slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    //返回环形链表中开始入环的第一个节点
    public static ListNode getFirstCircleNode1(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<ListNode>();
        while (head != null) {
            if (nodes.contains(head)){
                return head;
            }
            nodes.add(head);
            head = head.next;
        }
        return null;
    }

    //返回环形链表中开始入环的第一个节点
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode intect = test(head);
        if(intect == null) {
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

    private ListNode test(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)) {
                return fast;
            }
        }
        return null;
    }

    //返回环形链表中开始入环的第一个节点
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode intect = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)) {
                intect =  fast;
                break;
            }
        }

        if(intect == null) {
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


    //两个有序的链表合并
    public ListNode mergeTwoLists(ListNode l1 , ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode mergeHead = new ListNode(-1);

        ListNode cur = mergeHead;
        while (l1 != null & l2 != null) {
            if(l1.value <= l2.value){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return  mergeHead.next;
    }

    //删除链表倒数第n个结点
    public static ListNode deleteLastKth(ListNode head, int k) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode first = node;
        ListNode second = node;

        for (int i = 0; i<=k; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return node.next;
    }

    //求链表的中间结点
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //求两个链表的相交节点
    public static ListNode findIntectNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }


}
