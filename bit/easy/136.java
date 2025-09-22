class Solution {
    public int singleNumber(int[] nums) {
        result =0;
        for(int num : nums){
            result^=num;
        }
        return result;
    }
}