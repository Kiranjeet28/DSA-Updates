import java.lang.Math;

class Solution{
    public boolean helper(int nums[],int m ,int mid){
        int cal =0;
        int count =0;
        for(int n : nums){
            cal+=n;
            if(cal>mid){
                count++;
                cal = n;
            }
        }
        if(count>=m){
            return false;
        }
        return true;
    }
    public int splitArray(int nums[], int m){
        int left =0;
        int right =0;
      
        for(int n : nums){
            left = Math.max(left,n);
            right += n;
        }
        while(left < right){
            int mid = left+(right-left)/2;
            boolean ok = helper(nums,m,mid);
            if(ok){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public static  void main(String[] args){
        int nums[] = {1,2,3,4,5}; 
        int m =2;
        Solution sol = new Solution();
        System.out.println(sol.splitArray(nums,m));
    }
}
