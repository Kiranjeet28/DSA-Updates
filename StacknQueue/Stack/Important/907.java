import java.util.Stack;
// O(n^2) approach will give TLE
class Solution {
    private static final int MOD = 1_000_000_007;

    // Function that returns result as int
    public static int mod(long num) {
        return (int) ((num % MOD + MOD) % MOD);
    }

    public int sumSubarrayMins(int[] arr) {

        long result = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            st.push(arr[i]);
            int j = i;
            while (!st.isEmpty()) {
                if (st.peek() > arr[j]) {
                    st.pop();
                    st.push(arr[j]);
                    result += arr[j];
                } else {
                    result += st.peek();

                }
                if (j == 0)
                    st.removeAllElements();
                j--;
            }
            st.removeAllElements();
        }
        System.out.println(result);
        return mod(result);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 3, 1, 2, 4 };
        int result = sol.sumSubarrayMins(arr);
        System.out.println(result);
    }
}
// O(n) approach 
// NSE & PSE approach
Solution {
    private static final int MOD = 1_000_000_007;

    // Function that returns result as int
    public static int mod(long num) {
        return (int) ((num % MOD + MOD) % MOD);
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Find Next Smaller Elements
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find Previous Smaller Elements
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        long result = 0;

        // Calculate the result using the counts from NSE and PSE
        for (int i = 0; i < n; i++) {
            long countLeft = i - prevSmaller[i];
            long countRight = nextSmaller[i] - i;
            result += (arr[i] * countLeft * countRight) % MOD;
            result %= MOD;
        }

        return mod(result);
    }