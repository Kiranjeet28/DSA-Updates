class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is smaller than right neighbor,
            // peak must be on the right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // peak is on the left (including mid)
                right = mid;
            }
        }
        return left; // left == right, pointing to a peak
    }
}
