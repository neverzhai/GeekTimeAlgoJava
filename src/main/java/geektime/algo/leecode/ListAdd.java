package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-07 18:26
 * @description: 两个链表相加
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class ListAdd {

      public class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          return l1;
    }
}
