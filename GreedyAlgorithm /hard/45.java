// class Solution {
//     public int jump(int[] nums) {
//         if(nums.length <= 1) return 0;
//         int jump = 0;
//         int[] far = new int[nums.length];
//         for (int i = 0; i < nums.length; i++) {
//             far[i] = (nums.length - 1 - i) - nums[i];
//         }
//         int currIndex = 0;
//         int farVal = -1;
//         while (currIndex < nums.length - 1) {
//             // If we can directly reach or cross the end
//             if (currIndex + nums[currIndex] >= nums.length - 1) {
//                 jump++;
//                 break;
//             }

//             // Find index within range that gives minimum far value
//             int bestIndex = currIndex;
//             int minFar = Integer.MAX_VALUE;
//             for (int i = currIndex + 1; i <= currIndex + nums[currIndex] && i < nums.length; i++) {
//                 if (far[i] < minFar) {
//                     minFar = far[i];
//                     bestIndex = i;
//                 }
//             }

//             // Move to best index
//             currIndex = bestIndex;
//             jump++;
//         }

//         return jump;
//     }
  
//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         int[] nums1 = { 7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
//         System.out.println( solution.jump(nums1)); // Expected: 
//     }

// }
public int jump(int[] nums) {
    int jumps = 0, farthest = 0, end = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (i == end) {
            jumps++;
            end = farthest;
        }
    }
    return jumps;
}
