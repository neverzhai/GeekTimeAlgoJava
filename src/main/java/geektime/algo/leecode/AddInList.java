package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-29 17:21
 * @description:
 */
public class AddInList {

      public class ListNode {
        int val;
        ListNode next = null;

          public ListNode(int val) {
              this.val = val;
          }
      }

    public class Solution {
        /**
         *
         * @param head1 ListNode类
         * @param head2 ListNode类
         * @return ListNode类
         */
        public ListNode addInList(ListNode head1, ListNode head2) {
            // write code here
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            head1 = reverse(head1);
            head2 = reverse(head2);
            int p = 0;
            while (head1 != null && head2 != null) {
                int sum = head1.val + head2.val + p;
                p = sum >= 10 ? 1 : 0;
                curr.next= new ListNode(sum % 10);
                curr=curr.next;
                head1=head1.next;
                head2=head2.next;
            }

            while (head1 != null) {
                int sum = head1.val + p;
                p = sum >= 10 ? 1 : 0;
                curr.next= new ListNode(sum % 10);
                curr=curr.next;
                head1=head1.next;
            }
            while (head2 != null) {
                int sum = head2.val + p;
                p = sum >= 10 ? 1 : 0;
                curr.next= new ListNode(sum % 10);
                curr=curr.next;
                head2=head2.next;
            }
            if(p!=0){
                curr.next=new ListNode(p);
            }
            return reverse(dummy.next);
        }

        private ListNode reverse(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }
    }
}