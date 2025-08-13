class Solution {
       public int countOccurrences(int[] nums, int target) {
        int first = Binary(nums, target, true);
        int last = Binary(nums, target, false);

        if (first == -1 || last == -1) {
            return 0; // target not found
        }

        return last - first + 1;
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