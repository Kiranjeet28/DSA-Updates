import java.util.*;
import java.lang.Math;
class Solution {
    public List<Integer> sub(int[] nums, int n,List<Integer> sub){
        for(int i =0; i < nums.length; i++){
            if(((n>>i) & 1) == 1){
                sub.add(nums[i]);
            }
        }
        return sub;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i =1 ; i <=  Math.pow(2,nums.length); i++){
            result.add(sub( nums,i,new ArrayList<>()));
            
        } 

     return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3};
        System.out.println(sol.subsets(nums));
    }
}