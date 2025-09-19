/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head== null) return head;
        int l = 1;
        ListNode dummy = head;
        while(dummy.next!=null){
            l++;
            dummy = dummy.next;
        }
        int pos = k%l;
        if (pos == 0) return head;
        ListNode current = head;
        for (int i = 0; i < l - pos - 1; i++) {
            current = current.next;
        }

        ListNode newh = current.next;
        current.next = null;
        dummy.next =head;
        return newh;
    }
}