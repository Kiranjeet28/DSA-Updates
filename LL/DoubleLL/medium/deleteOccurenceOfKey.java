// Delete all occurrences of a key in DLL

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}

class Solution {
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        // Create a dummy node to simplify deletion
        
        if (head != null) head.prev = null;

        ListNode temp = head;
        while (temp != null) {
            if (temp.val == target) {
                ListNode prev = temp.prev;
                ListNode next = temp.next;

                prev.next = next;
                if (next != null) next.prev = prev;
            }
            temp = temp.next;
        }

        // Return the new head (could have changed)
        return dummy.next;
    }
}
/// We can set prev & next for null so we  have check like if (next != null) next.prev = prev; for end 
// for start we use dummy  

