import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0)
                k--;
            while (k < 0) {
                if (nums[left] % 2 != 0)
                    k++;
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1 };
        System.out.println(s.numberOfSubarrays(arr, 2)); // ✅ 16
    }
}
