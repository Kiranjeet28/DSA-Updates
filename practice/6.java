class Solution {
    public boolean check(int[] days, int day, int m , int k ){
    	int boquee = 0;
    	int count = 0;
    	for(int d : days ){ 
    		if(d <= day ){
    			count++;
    			if(count == k ){
    				boquee++;
    				count =0;
    			}
    		}else{
    			count = 0;
    		}	
    	}
    	return boquee >= m; 
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        if((long)m * k > bloomDay.length) return -1;
        for(int day : bloomDay){
        	maxDay = Math.max(maxDay,day);
        	minDay = Math.min(minDay,day);
	}
	int high = maxDay;
	int low = minDay;
	int mid = 0;
	while(high > low ){
		mid = low + (high - low)/2;
		if(check(bloomDay,mid,m,k)){
			high = mid; 
			
		}else{
		 
		 	low = mid+1;
		}
	}
	return low; 
    }
}
