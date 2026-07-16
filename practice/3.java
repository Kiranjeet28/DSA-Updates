import java.util.*;
class Solution{
	public int[] Ledder(int[] nums){
	  int n = nums.length;
		
		ArrayList<Integer> list = new ArrayList<>();
		int maxElement = 0;
		for(int i = n -1; i >= 0; i--){
		    if(nums[i] > maxElement){
		      list.add(nums[i]);
		      maxElement = nums[i];
		    }
		  }
		  int[] result = new int[list.size()];
		  for(int i = 0; i < list.size();i++){
		    result[i] = list.get(i);
		  }
		  return result;
		}

	
	public static void main(String[] args){
	  Solution s = new Solution();
	  int[] nums = {16, 17, 4, 3, 5, 2};
	  int[] result = s.Ledder(nums);
	  for(int i =0; i < result.length; i++){
	    System.out.println(result[i]);
	  }
	}
}
