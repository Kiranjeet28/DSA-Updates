// BRUTE FROCE 
//  class Solution {
//     public int maxProduct(int[] nums) {
//         int len = nums.length;
//         int product = nums[0];
//         // HashMap<Integer, Integer> sets = new HashMap<>();
//         for(int i = 0 ; i < len ; i++){
//         int minProduct =1;
//             for(int j =i ; j < len ; j++){
//                  minProduct*=nums[j];
//                  System.out.println(minProduct);
                
//                     if(minProduct>product){
//                         product = minProduct;
//                     }
                
//             }
//         }
//         return product;
//     }
// }


// optimized 2 pointer approach
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int product = nums[0];
        int leftProduct = 1, rightProduct = 1;
        for (int i = 0; i < len; i++) {
            leftProduct = (leftProduct == 0 ? 1 : leftProduct) * nums[i];
            rightProduct = (rightProduct == 0 ? 1 : rightProduct) * nums[len - 1 - i];
            product = Math.max(product, Math.max(leftProduct, rightProduct));
        }
        return product;
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,-2,-3,0};
        int result = solution.maxProduct(nums);
        System.out.println("Maximum product of subarray: " + result);
    }
}