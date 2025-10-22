import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];

        Arrays.fill(prevSmaller, -1);
        Arrays.fill(prevGreater, -1);
        Arrays.fill(nextSmaller, n);
        Arrays.fill(nextGreater, n);

        Stack<Integer> st = new Stack<>();

        // previous smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // next smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // previous greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
            prevGreater[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // next greater
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            nextGreater[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long total = 0;

        for (int i = 0; i < n; i++) {
            long leftMin = i - prevSmaller[i];
            long rightMin = nextSmaller[i] - i;
            long leftMax = i - prevGreater[i];
            long rightMax = nextGreater[i] - i;

            long countMin = leftMin * rightMin;
            long countMax = leftMax * rightMax;

            total += (countMax - countMin) * nums[i];
        }

        return total;
    }
}
