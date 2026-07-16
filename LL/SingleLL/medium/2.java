 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);  // placeholder
        ListNode current = dummy;          // start at dummy

        ListNode a = l1;
        ListNode b = l2;

        while (a != null || b != null) {
            int val1 = (a != null) ? a.val : 0;
            int val2 = (b != null) ? b.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10); // append node
            current = current.next;                // move current

            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next; // skip placeholder
    }
}
