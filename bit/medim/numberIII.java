// Given an array nums of length n, every integer in the array appears twice except for two integers. Identify and return the two integers that appear only once in the array. Return the two numbers in ascending order.
class Solution {    
    public int[] singleNumber(int[] nums) {   
        int[] result = new int[2];   
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // Find a set bit (rightmost)
        int diff = xor & -xor;
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        // Return in ascending order
        if (result[0] > result[1]) {
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        return result;
    }
}