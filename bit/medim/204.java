// ###Sieve of Eratosthenes
import java.util.Arrays;
import java.lang.Math;
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 10;
        System.out.println("Number of primes less than " + n + ": " + sol.countPrimes(n));
    }
}
