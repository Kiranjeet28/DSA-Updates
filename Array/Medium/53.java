class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArraySum = sol.maxSubArray(nums);
        System.out.println("Maximum subarray sum is: " + maxSubArraySum);
    }
}
