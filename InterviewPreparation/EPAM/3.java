/*Second Maximum Element
Identify the second largest element in an array without sorting.Programming

Input: Array of integers
Output: Second largest integer */
class Solution{
    public static int check(int[] arr){
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for(int n : arr ){
            if(max < n) { 
                secondMax = max;
                max = n ; 
            }else if (secondMax < n && n < max) {
                secondMax = n;
            }
        }
        
       
        return secondMax;
    } 
    public static void main(String args[] ){
        Scanner s = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0 ;i < 5 ; i++){
            arr[i] = s.nextInt();
        }
        System.out.println(check(arr));
    }
}