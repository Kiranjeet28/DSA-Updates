class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        
        int k = (nums1.length + nums2.length) ;
	double[] result = new double[k];
	int n = k-1;
        while(i >= 0 && j >= 0 ){
        	if(nums1[i] > nums2[j]){
        		result[n] = nums1[i];
        		i--;
        	}else{
			result[n] = nums2[j];
        		j--;
        	}
        	n--;
        }
        while(i>= 0){
        	result[n] = nums1[i];
        	i--;
        	n--;
        }
        while(j>= 0){
        	result[n] = nums2[j];
        	j--;
        	n--;
        }
	if(k % 2 != 0){
		return result[k/2];
	}else{
		return (result[k/2 - 1] + result[k/2]) / 2.0;
		
	}
	
    }
}
