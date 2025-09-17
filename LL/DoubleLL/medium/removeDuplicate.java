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
    public ListNode removeDuplicates(ListNode head) {

        if(head== null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        while(temp!=null ){
            if(temp.prev.val == temp.val){
                // remove current 
                ListNode prev = temp.prev;
                if(next!= null) ListNode next = temp.next ;
                next.prev = prev;
               if (next != null) {
                    next.prev = prev;
                }

            }
            temp = temp.next;
        }
        return head;
    }
}