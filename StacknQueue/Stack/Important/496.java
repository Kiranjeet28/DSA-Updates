import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greaterValues = new int[nums2.length];
        int[] ans = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i > -1; i--) {
            if (st.isEmpty())
                greaterValues[i] = -1;
            else if (st.peek() > nums2[i])
                greaterValues[i] = st.peek();
            else {
                while (!st.isEmpty() && st.peek() < nums2[i]) {
                    st.pop();
                }
                if (st.isEmpty())
                    greaterValues[i] = -1;
                else
                    greaterValues[i] = st.peek();
            }
            st.push(nums2[i]);

        }
        for (int j = 0; j < nums1.length; j++) {
            for (int k = 0; k < nums2.length; k++) {
                if (nums1[j] == nums2[k]) {
                    ans[j] = greaterValues[k];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {2,4}; 
        int[] nums2 = {1,2,3,4};
        int[] result = sol.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
// we can optimize using hashmap to store the index of nums2 elements