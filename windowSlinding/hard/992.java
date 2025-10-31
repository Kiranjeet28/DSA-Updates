import java.util.HashMap;
import java.util.Map;

public class Solution {
    // main function: returns number of subarrays with exactly k distinct ints
    public int subarraysWithKDistinct(int[] nums, int k) {
        if (k <= 0)
            return 0;
        long atMostK = countAtMostK(nums, k);
        long atMostKminus1 = countAtMostK(nums, k - 1);
        long result = atMostK - atMostKminus1;
        // cast to int; be aware of overflow for very large arrays (use long return if
        // needed)
        return (int) result;
    }

    // helper: number of subarrays with at most k distinct elements
    private long countAtMostK(int[] nums, int k) {
        if (k < 0)
            return 0; // helper convenience
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long count = 0L;

        for (int right = 0; right < nums.length; right++) {
            int curr = nums[right];
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);

            while (freq.size() > k) {
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);
                if (freq.get(leftVal) == 0) {
                    freq.remove(leftVal);
                }
                left++;
            }
            // All subarrays ending at 'right' with start in [left..right] are valid
            count += (right - left + 1);
        }
        return count;
    }

    // quick test
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1, 2, 1, 2, 4 };
        System.out.println("Result: " + s.subarraysWithKDistinct(arr, 2)); // expected 5
    }
}
