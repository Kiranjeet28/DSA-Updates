import java.lang.Math;

class Solution {
    public boolean helper(int[] c, int mid, int A) {
        int painters = 1;
        int total = 0;
        for (int n : c) {
            total += n;
            if (total > mid) {
                painters++;
                total = n;
                if (painters > A) return false;
            }
        }
        return true;
    }

    public int paint(int A, int B, int[] C) {
        int left = 0;
        int right = 0;
        for (int n : C) {
            left = Math.max(left, n);
            right += n;
        }
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (helper(C, mid, A)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)((long)ans * B % 10000003);
    }

    public static void main(String[] args) {
        int nums[] = {5, 10, 30, 20}; 
        int A = 3;
        int B = 2;
        Solution sol = new Solution();
        System.out.println(sol.paint(A, B, nums));
    }
}
