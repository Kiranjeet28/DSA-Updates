class ListNode {
    int val;
    ListNode next;

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
    public ListNode sortList(ListNode head) {
        int count0 = 0, count1 = 0, count2 = 0;
        ListNode temp = head;
        // Count the number of 0s, 1s, and 2s in the list
        while (temp != null) {
            if (temp.val == 0) count0++;
            else if (temp.val == 1) count1++;
            else count2++;
            temp = temp.next;
        }
        temp = head;
        // Overwrite the values in the list based on the counts
        while (temp != null) {
            if (count0 > 0) {
                temp.val = 0;
                count0--;
            } else if (count1 > 0) {
                temp.val = 1;
                count1--;
            } else {
                temp.val = 2;
                count2--;
            }
            temp = temp.next;
        }
        return head;
    }
    
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);
        Solution obj = new Solution();
        obj.sortList(head);
        System.out.print("null->");

        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
    }

}