// Brute Force Approach
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
       
        // Count nodes by traversing one by one
        int Fastcount = 0;
        ListNode curr = head;
        while (curr != null) {
            Fastcount++;
            curr = curr.next;
        }
        int count = Fastcount - n; //n=2
        System.out.println("count " + Fastcount);
        if(count ==1 & Fastcount ==2 ){
            head.next = null;
            return head;
        }else 
        if(count == 0 ){
            head = head.next;
        }else{
            int calCount = 1;

            ListNode temp = head;
            while(temp!=null &&  temp.next != null){
                System.out.print(temp.val + " " );
                System.out.println(calCount);
                if(count == calCount){
                    temp.next = temp.next.next;
                    return head;
                }
                temp = temp.next;
                calCount++;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        // Example: create list 1->2->3->4->5
        ListNode head = new ListNode(3,
            new ListNode(1,null));

        Solution sol = new Solution();
        int n = 1; // Remove 2nd node from end
        head = sol.removeNthFromEnd(head, n);

        // Print result
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}

// Optimal Approach
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(); //default value is 0
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;

    }
}