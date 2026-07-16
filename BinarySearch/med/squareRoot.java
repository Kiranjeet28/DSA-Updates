class Solution{
    public static int mySqrt(int num){
        int left =1;
        int right = num;
        int ans =0;
        while(left<=right){
           int mid = left + (right - left) / 2; // avoid overflow
            long square = (long) mid * mid;
            System.out.println(square);
            if(square==num){
                return mid;
            } else if (square > num) {
                right = mid - 1;
            } else {
                ans = mid;   // mid is a valid candidate
                left = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int num = 28;
        System.out.println(mySqrt(num));
    }
}