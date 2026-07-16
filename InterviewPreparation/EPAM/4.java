/*
4. Find Missing Number
Find the missing number in an array of consecutive integers.

Input: Array of n-1 integers from 1 to n
Output: Missing integer
 */

class Solution{
    public static int check(int[] arr){
       int n = arr.length + 1;

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
    public static void main(String[] args){
        int[] arr = {1,3,4,5};
        System.out.println(check(arr));
    }
}