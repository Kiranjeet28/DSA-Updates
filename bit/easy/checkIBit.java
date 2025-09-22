class Solution {
    public boolean checkIthBit(int n, int i) {

        int arr[] = new int[i+1];  // array of size i+1
        int arrPointer = 0;

        while(n > 0 && arrPointer <= i){
            if(n % 2 == 0){
                arr[arrPointer] = 0;
            } else {
                arr[arrPointer] = 1;
            }
            n = n / 2;   // move to next bit
            arrPointer++;
        }

        // if arr[i] == 1 → ith bit is set
        return arr[i] == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkIthBit(5,0)); // true (binary 101 → 0th bit = 1)
        System.out.println(s.checkIthBit(5,1)); // false (binary 101 → 1st bit = 0)
        System.out.println(s.checkIthBit(5,2)); // true (binary 101 → 2nd bit = 1)
    }
}
public boolean checkIthBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }