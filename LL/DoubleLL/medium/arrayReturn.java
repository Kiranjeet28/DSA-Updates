import java.util.*;
class ListNode {
    int value;
    ListNode next;
    ListNode prev;
    
    ListNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class Solution {
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> list = new ArrayList<>();

        if(head== null || head.next == null){
            return list;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next !=null){
            if(p2.value > target) break;
            p2 = p2.next;
        }

        while(p2.value > p1.value){
            
            int req = target - p1.value;
            if(p2.value == req){
                List<Integer> l1 = new ArrayList<>();
                l1.add(p1.value);
                l1.add(p2.value);

                list.add(l1);
                if(list.size()== 2){
                    return list;
                }
                p1 = p1.next ;
                p2 = p2.prev;
            }
            else if(req> p2.value){
                p1=p1.next;
            }else {
               p2 = p2.prev;
            }
        }
        return list;
    }
    public class Main {
    public static void main(String[] args) {
        // Create doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        Solution sol = new Solution();
        List<List<Integer>> result = sol.findPairsWithGivenSum(head, 6);

        System.out.println(result); // [[1, 5], [2, 4]]
    }
}

}