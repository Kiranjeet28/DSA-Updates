class Solution {

    public int[] swap(int a, int b) {
        int arr[] = new int[2]
       a = a^b;
       b= a^b;
       a = a ^b;
       arr[0] = a;
       arr[1] = b;
       return arr;
    }
}
