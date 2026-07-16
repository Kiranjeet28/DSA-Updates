// import java.util.*;

// class Solution {

//     public HashSet<List<Integer>> rec(HashSet<List<Integer>> FL, List<Integer> curr, int[] arr,int pos) {
//         if (pos == arr.length) {
//             System.out.println(FL);
//             return FL;
//         }
       

//         List<Integer> NextList = new ArrayList<>(curr);
//         NextList.add(arr[pos]);
//         Collections.sort(NextList);
//         FL.add(NextList);
//         System.out.println(NextList);
//         rec(FL, NextList, arr, pos + 1);
//         rec(FL, curr, arr, pos + 1);
//         return FL;
//     }

//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//             Arrays.sort(nums);
//         List<List<Integer>> FL = new ArrayList<>();
//         if (nums.length > 1) {

//             Arrays.sort(nums);
//         }
//         List<Integer> n = new ArrayList<>();
//         HashSet<List<Integer>> setOfLists = new HashSet<>();
//         FL.add(n);
//         rec(setOfLists, n, nums, 0);
//         for (List<Integer> hn : setOfLists) {
//             FL.add(hn);
//         }
//         System.out.println(FL);
//         return FL;

//     }

//     public static void main(String[] args) {
//         int arr[] = {1,1,1,1,1,1,1,1,1,111};
//         Solution s = new Solution();
//         s.subsetsWithDup(arr);
//     }
// }

// optimized
import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add current subset

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1])
                continue;

            current.add(nums[i]); // Include nums[i]
            backtrack(nums, i + 1, current, result); // Recurse
            current.remove(current.size() - 1); // Backtrack
        }
    }
}