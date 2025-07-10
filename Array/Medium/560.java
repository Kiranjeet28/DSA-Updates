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
class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int subSet = 0;

        for (int i = 0; i < length; i++) {
            int currentSum = 0;
            for (int j = i; j < length; j++) {
                currentSum += nums[j];
                System.out.println("Subarray from " + i + " to " + j + ", sum = " + currentSum);
                if (currentSum == k) {
                    subSet++;
                }
            }
        }
        return subSet;
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
