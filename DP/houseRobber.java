import java.util.*;

class Solution {

    int n;
    int[] dp;

    int houseRobber(int[] arr) {

        n = arr.length;

        if (n == 1)
            return arr[0];

        // Case 1: Exclude last house
        dp = new int[n];
        Arrays.fill(dp, -1);
        int case1 = DP(arr, 0, n - 2);

        // Case 2: Exclude first house
        dp = new int[n];
        Arrays.fill(dp, -1);
        int case2 = DP(arr, 1, n - 1);

        return Math.max(case1, case2);
    }

    int DP(int[] arr, int idx, int end) {

        if (idx > end)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int MaxValue = arr[idx] + DP(arr, idx + 2, end);

        MaxValue = Math.max(MaxValue, DP(arr, idx + 1, end));

        dp[idx] = MaxValue;

        return dp[idx];
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter the size of the Array : ");
        int n = s.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter your Array : ");

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        Solution obj = new Solution();

        int check = obj.houseRobber(arr);

        System.out.println("Here is your Result : " + check);
    }
}