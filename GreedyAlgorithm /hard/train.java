import java.util.Arrays;

class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        int n = Arrival.length;
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int platformNeeded = 1, maxPlatforms = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (Arrival[i] <= Departure[j]) {
                platformNeeded++;
                i++;
                maxPlatforms = Math.max(maxPlatforms, platformNeeded);
            } else {
                platformNeeded--;
                j++;
            }
        }

        return maxPlatforms;
    }
}
