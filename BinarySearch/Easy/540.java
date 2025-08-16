class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even (so mid, mid+1 can form a pair)
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                // Pair is correct → single is on right side
                left = mid + 2;
            } else {
                // Pair is broken → single is on left side (including mid)
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,3,7,7,10,11,11};
        int result = solution.singleNonDuplicate(nums);
        System.out.println("The single non-duplicate element is: " + result); // 10
    }
}
