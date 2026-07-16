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
 // Method reverse list -- > list structure if modified 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode result = null
        ListNode revOfA  = listReverse(headA);
        ListNode revOfB  = listReverse(headB);
        int result = 0 ; 
        while(revOfA != null && revOfB != null ){
        if(revOfA.val == revOfB.val) return revOfA;
          revOfA = revOfA.next;
          revOfB = revOfB.next;
        }
        return result;
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
// 2 pointer approach 

class Solution{
  public ListNode approach(ListNode headA, ListNode headB ){
   ListNode a = headA;
    ListNode b = headB;

    while (a != b) {
        a = (a == null) ? headB : a.next;
        b = (b == null) ? headA : b.next;
    }

    return a;
  }
}
