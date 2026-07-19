import java.util.*;

class Solution {

    public static int[] goals(int[] teamA, int[] teamB) {

        Arrays.sort(teamA);

        int[] result = new int[teamB.length];

        for (int i = 0; i < teamB.length; i++) {
            result[i] = upperBound(teamA, teamB[i]);
        }

        return result;
    }

    // Returns count of elements <= target
    public static int upperBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] teamA = {1, 2, 3};
        int[] teamB = {2, 4};

        int[] ans = goals(teamA, teamB);

        System.out.println(Arrays.toString(ans));
    }
}
