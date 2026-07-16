import java.util.*;

class Solution{
	public int longestConsecutiveSubsequence(int[] nums){
	
		Set<Integer> st = new HashSet<>();
		int res = 0;
		for(int n : nums){
			st.add(n);
		}
		for(int val: nums){
		if (st.isEmpty()) break;
		int curr = 0;
			int currVal = val;
			if(st.contains(currVal) && !st.contains(currVal-1)){
				while(st.contains(currVal)){
					st.remove(currVal);
					curr++;
					currVal++;
				}
			}
			res = Math.max(res,curr);
		}
	return res;
	}
}
