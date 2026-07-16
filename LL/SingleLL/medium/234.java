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
    public boolean isPalindrome(ListNode head) {
         ListNode slow = head; // moves 1 step
        ListNode fast = head; // moves 2 steps

        // Move fast pointer twice as quickly as slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move 1 step
            fast = fast.next.next;    // move 2 steps
        }
        ListNode secondHalfStart = rec(slow);
        ListNode firstHalfStart = head;
        while(secondHalfStart != null){
            if(firstHalfStart.val != secondHalfStart.val){
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
    public ListNode rec(ListNode head){
         ListNode curr = head;
        ListNode prev = null;
         while(curr!= null){
            ListNode next = curr.next;
            curr.next = prev; // <- pointer to previsour 
            prev = curr; // change value
            curr = next ; // for next irration 
         }
    return prev ;
}