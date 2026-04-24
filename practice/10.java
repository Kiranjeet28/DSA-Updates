/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 // Method reverse list 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode revOfA  = listReverse(headA);
        ListNode revOfB  = listReverse(headB);
        int result = 0 ; 
        while(revOfA != null && revOfB != null ){
        if(revOfA.val == revOfB.val) return revOfA.val;
          revOfA = revOfA.next;
          revofB = revofB.next;
        }
        return 0 
    }
    
     public ListNode listReverse(ListNode head) {
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
}
