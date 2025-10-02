// O(N) time complexity
class Solution {
    public int xor(int n , int r) {
        if(n == r) return r;
        return xor(n + 1, r) ^ n;
    }
    public int findRangeXOR(int l, int r) {
        if(l == r) return l;
        
        return l ^ xor(l + 1,r);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int l = 4, r = 10;
        System.out.println("Range XOR from " + l + " to " + r + " is: " + sol.findRangeXOR(l, r));
    }
}
// O(1) time complexity
class Solution {
    // XOR from 0 to n
    private int xorToN(int n) {
        int mod = n % 4;
        if (mod == 0) return n;
        if (mod == 1) return 1;
        if (mod == 2) return n + 1;
        return 0;
    }

    // XOR from l to r
    public int findRangeXOR(int l, int r) {
        return xorToN(r) ^ xorToN(l - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int l = 4, r = 10;
        System.out.println("Range XOR from " + l + " to " + r + " is: " + sol.findRangeXOR(l, r));
    }
}
