import java.util.Collection;
import java.util.PriorityQueue;

class Solution {

    public static int findKthSmallest(int[] nums, int k) {
        // Min Heap (default in Java)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

        }
        int f = k - 1;
        while(f>0){
            minHeap.remove();
            f--;
        }

        // Root of minHeap is the kth smallest
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        System.out.println("Kth largest element: " + findKthLargest(nums, k));
    }
}
