  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: check if there are at least k nodes
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If nodes < k → return head (no reversal)
        if (count < k) return head;

        // Step 2: reverse first k nodes
        ListNode prev = null, next = null;
        curr = head;
        count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 3: recursively reverse the rest
        head.next = reverseKGroup(curr, k);

        // 'prev' is new head of this reversed block
        return prev;
    }
}