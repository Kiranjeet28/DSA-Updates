import java.util.*;
class Solution {
    public static int helper(int[] arr,int mid){
        int sum =0;
        for(int num: arr){
            sum += (int) Math.ceil((double) num / mid);
        }
        return sum;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right =0;
        for(int num : piles){
             right = Math.max(right,num);
        }

       
        while (left < right) {
            int mid = left + (right - left) / 2;
            int result = helper(piles, mid);

            if (result <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args){
        int piles[] = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles,h));
    }
}