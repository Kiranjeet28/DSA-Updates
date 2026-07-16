import java.util.*;

class Solution {
    // Function to calculate mid^n safely
    public static long calculate(int mid, int n) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= mid;
            if (ans > Long.MAX_VALUE / 2) break; // prevent overflow
        }
        return ans;
    }

    public static int nthRoot(int n, int m) {
        int left = 1;
        int right = m;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long power = calculate(mid, n);
            
            if (power == m) {
                return mid;
            } else if (power > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1; // not an integer root
    }

    public static void main(String[] args) {
        int N1 = 3, M1 = 27;
        System.out.println(nthRoot(N1, M1)); // Output: 3
        
        int N2 = 4, M2 = 69;
        System.out.println(nthRoot(N2, M2)); // Output: -1
    }
}
