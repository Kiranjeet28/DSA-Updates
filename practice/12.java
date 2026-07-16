/*Definition for singly Linked List
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
*/

// using merge sort 
class Solution {

    public ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Step 1: flatten right side
        head.next = flattenLinkedList(head.next);

        // Step 2: merge current list with next list
        head = merge(head, head.next);

        return head;
    }

    // Merge two sorted linked lists using child pointer
    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode result;

        if (a.val < b.val) {
            result = a;
            result.child = merge(a.child, b);
        } else {
            result = b;
            result.child = merge(a, b.child);
        }

        result.next = null; // IMPORTANT
        return result;
    }
}
