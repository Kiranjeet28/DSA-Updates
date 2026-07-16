import java.util.Arrays;

class Solution {
    public boolean helper(int[] arr, int k, int mid) {
        int cows = 1;
        int acc = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            acc += (arr[i + 1] - arr[i]);
            if (acc >= mid) {
                cows++;
                acc = 0;
                if (cows >= k) return true;
            }
        }
        return cows >= k;
    }

    public int aggressiveCows(int[] nums, int cows) {
        Arrays.sort(nums);

        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean ok = helper(nums, cows, mid);
            if (ok) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 3, 4, 7, 10, 9};
        int cows = 4;
        System.out.println(sol.aggressiveCows(nums, cows));
    }
}
