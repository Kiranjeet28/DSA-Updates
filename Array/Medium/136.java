import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        // Your original logic (with some corrections)
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 2, 1};
        int single = sol.singleNumber(nums);
        System.out.println("Single number is: " + single);
    }
}
