class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        ans[0] = Binary(nums, target, true);
        ans[1] = Binary(nums, target, false);
        return (ans);
    }

    int Binary(int[] nums, int target, boolean findfirst) {
        int ans = -1;
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                ans = mid;
                if (findfirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (ans);
    }

}