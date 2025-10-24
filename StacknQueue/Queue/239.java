import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution {
    public boolean isFull(Queue<Integer> deque, int k) {
        if(deque.size() == k ){
            return true;
        }
        return false;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < n ; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
          deque.offerLast(i);
            if (i + 1 >= k) {
                res[j++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
