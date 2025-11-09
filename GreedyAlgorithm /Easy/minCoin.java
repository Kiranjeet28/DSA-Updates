import java.util.Arrays;

class Solution {
    public int MinimumCoins(int[] coins, int amount) {
        Arrays.sort(coins); // sort ascending
        int coinCount = 0;
        int remaining = amount;

        // start from largest coin
        for (int i = coins.length - 1; i >= 0 && remaining > 0; i--) {
            if (coins[i] <= remaining) {
                int use = remaining / coins[i]; // take as many of this coin as possible
                coinCount += use; // count how many we used
                remaining -= use * coins[i]; // reduce the remaining amount
            }
        }

        // if we couldn’t make exact amount
        if (remaining != 0)
            return -1;
        return coinCount;
    }
}
// greedy will never give correct answer 
