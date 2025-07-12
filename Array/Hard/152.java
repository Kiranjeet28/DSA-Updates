class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int product = nums[0];
        // HashMap<Integer, Integer> sets = new HashMap<>();
        for(int i = 0 ; i < len ; i++){
        int minProduct =1;
            for(int j =i ; j < len ; j++){
                 minProduct*=nums[j];
                 System.out.println(minProduct);
                
                    if(minProduct>product){
                        product = minProduct;
                    }
                
            }
        }
        return product;
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,3,-4};
        int result = solution.maxProduct(nums);
        System.out.println("Maximum product of subarray: " + result);
    }
}