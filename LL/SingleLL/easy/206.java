/* by Itraction */
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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
         while(curr!= null){
            ListNode next = curr.next;
            curr.next = prev; // <- pointer to previsour 
            prev = curr; // change value
            curr = next ; // for next irration 
         }
    return prev ;}
    
}
/*BY recursion*/
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
    public ListNode rec(ListNode curr, ListNode prev){
        while(curr== null){
            return prev;
        }
           ListNode next = curr.next;
            curr.next = prev; // <- pointer to previous
            return rec(next, curr);
         
    }
    public ListNode reverseList(ListNode head) {
 
    return rec(head,null) ;}
    
}