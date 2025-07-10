// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int length = nums.length;
//         int previousSum =0 ;
//         int subSet = 0;
//         int i =0;
//         while(i<length){
//             for(int j = i ; j<length ; j++){
//                 previousSum+=nums[j];
//                 System.out.println("Adding " + nums[j] + " to previousSum: " + previousSum);
//                 System.out.println("Current sum: " + previousSum);
//                 if(previousSum == k){
//                     subSet+=1;
//                     previousSum = 0; // Reset previousSum for the 
//                     i++;
//                     break;
//                 }
//             }
//         }
//         return subSet;
//     }
// }
// class Main{
//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         int[] nums = {1, 2,3};
//         int k = 2;
//         int result = solution.subarraySum(nums, k);
//         System.out.println("Number of subarrays: " + result);
//     }
// }
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int preSum = 0, count = 0;

        mpp.put(0, 1); // Base case: a prefix sum of 0 exists once.

        for (int i = 0; i < n; i++) {
            preSum += arr[i]; // Calculate current prefix sum

            int remove = preSum - k; // Find the required prefix sum to form a subarray with sum k
            count += mpp.getOrDefault(remove, 0); // Add the count of such prefix sums if present

            // Update the map with current prefix sum count
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}


class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3,4,5,6,7,8,9,10};
        int k = 3;
        int result = solution.subarraySum(nums, k);
        System.out.println("Number of subarrays: " + result);
    }
}
