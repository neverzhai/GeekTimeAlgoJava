package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-08 08:49
 * @description: 234. 回文链表
 *  注意: 不要将原链表反转再判断, 因为反转后回破坏原来的链表结构
 */
public class IsPalindromeList {

//      Definition for singly-linked list.
static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

//    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(1);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//        ListNode listNode = reverseList(node1);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//
//        boolean palindrome = isPalindrome(node1);
//        System.out.println(palindrome);
//    }

 public boolean isPalindrome(ListNode head) {
     if (head == null) {
         return true;
     }

     // 找到前半部分链表的尾节点并反转后半部分链表
     ListNode firstHalfEnd = endOfFirstHalf(head);
     ListNode secondHalfStart = reverseList(firstHalfEnd.next);

     // 判断是否回文
     ListNode p1 = head;
     ListNode p2 = secondHalfStart;
     boolean result = true;
     while (result && p2 != null) {
         if (p1.val != p2.val) {
             result = false;
         }
         p1 = p1.next;
         p2 = p2.next;
     }

     // 还原链表并返回结果
     firstHalfEnd.next = reverseList(secondHalfStart);
     return result;
 }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
