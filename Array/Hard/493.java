import java.util.*;
// only for <500 test cases Well DOne 
class Solution {
    public int reversePairs(int[] nums) {
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int count = 0;
            List<Long> sortedList = new ArrayList<>();
            for (int j = i + 1; j < len; j++) {
                sortedList.add((long) nums[j]);
            }
            Collections.sort(sortedList);
            while ((long) nums[i] > sortedList.get(count) * 2) {
                result++;
                if (count < sortedList.size() - 1) {
                    count++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 2, 3, 1};
        int result = solution.reversePairs(nums);
        System.out.println("Number of reverse pairs: " + result);
    }
}

/// Solution using Merge Sort
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // Count important reverse pairs
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        // Merge step (standard merge sort)
        int[] temp = new int[right - left + 1];
        int i = left, k = 0;
        j = mid + 1;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        // Copy back
        System.arraycopy(temp, 0, nums, left, temp.length);

        return count;
    }
}
