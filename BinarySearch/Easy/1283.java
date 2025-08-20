import java.lang.Math;
class Solution{
    public double helper(int arr[],int mid){
        double sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += Math.ceil((double)arr[i]/mid);
        }
        return sum;
    }
     public int smallestDivisor(int[] nums, int threshold) {
        int left =1;
        int right = 0;
        for(int num : nums){
            right = Math.max(right, num);
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            if(helper(nums, mid) > threshold){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
       Solution sol = new Solution();
        int[] nums = {44,22,33,11,1};
        int threshold = 5;
        System.out.println(sol.smallestDivisor(nums, threshold)); // Output: 5
    }
}