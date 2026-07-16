class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class Solution {
    public ListNode addOne(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
           temp = temp.next;
        }
        if(temp.val != 9){
            temp.val = temp.val + 1;
            return head;
        }
        else{
            temp.val = 0;
            ListNode newHead = rec(head);
            ListNode curr = newHead;
            while (curr != null && curr.next != null){
                if(curr.val != 9){
                    curr.val = curr.val + 1;
                    break;
                }
               
                curr = curr.next;
            }
            if(curr.val == 9){
                ListNode newNode = new ListNode(1);
                curr.val = 0;
                newNode.next = newHead;
                newHead = newNode;
            }
        }
        return rec(newHead);
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
}