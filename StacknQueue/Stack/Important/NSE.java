import java.util.*;

class Solution {
    public int[] nextSmallerElements( int[] nums) {
        int[] smallerValues = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i > -1; i--) {
            if (st.isEmpty())
                smallerValues[i] = -1;
            else if (st.peek() < nums[i])
                smallerValues[i] = st.peek();
            else {
                while (!st.isEmpty() && st.peek() > nums[i]) {
                    st.pop();
                }
                if (st.isEmpty())
                    smallerValues[i] = -1;
                else
                    smallerValues[i] = st.peek();
            }
            st.push(nums[i]);

        }
       

        return smallerValues;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 10, 9, 8, 7};
        int[] result = sol.nextSmallerElements(nums);
        System.out.println(Arrays.toString(result));
    }
}
// we can optimize using hashmap to store the index of nums elements