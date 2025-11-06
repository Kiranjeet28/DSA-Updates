import java.util.*;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // Add elements to the heap
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll(); // remove smallest
        }
        return minHeap.peek(); // kth largest
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
