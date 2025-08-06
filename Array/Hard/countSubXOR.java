// https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
import java.util.*;
class Solution {
    public int subXor(int[] arr, int x){
        int count=0;
        int xor =0 
        HashMap<Integer,Integer> map = new HashMap<>();
       map.put(0, 1);
        for(int num : nums){
            xor ^= num;

        int required = xor ^ x;
        count += map.getOrDefault(required, 0);

        map.put(xor, map.getOrDefault(xor, 0) + 1);

        }
return count;
    }
}
class Main {
    public static void main(String[] args) {
        Solution S1 = new Solution();
           int arr[] = {5, 6, 7, 8, 9};

       int result =  S1.subXor(arr,5);
       System.out.println(result);
    }
}