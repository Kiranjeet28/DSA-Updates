class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int window = 0 ;
        int count =0;
         for(int num : nums){
            if(num==1){
                window+=1;
                count = Math.max(window,count);
            }else{
                window=0;
            }
         }
         return count;
    }
}