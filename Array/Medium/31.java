class Solution {
    // Reverse the subarray from pos to the end
    public void swap(int pos, int[] nums){
        int left = pos, right = nums.length - 1;
        int temp =0 ;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public int justGreater(int pos,int[] nums){
        int minPost = pos+1;
        for(int i = pos+1; i < nums.length; i++){
            if(nums[i] > nums[pos]){
                minPost = i;
            }
        }
        return minPost;
    }
    public void nextPermutation(int[] nums) {
     int pos2 = nums.length - 2;
     int pos1 = nums.length - 1;
        while(pos2 >= 0 && nums[pos2] >= nums[pos1]){
            pos2--;
            pos1--;
        }
        if(pos2 >= 0){
            int justGreaterPos = justGreater(pos2, nums);
            int temp = nums[pos2];
            nums[pos2] = nums[justGreaterPos];
            nums[justGreaterPos] = temp;        
        }
            swap(pos2 + 1, nums);


    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,3,2};
        sol.nextPermutation(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}