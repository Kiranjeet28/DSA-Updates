package AdvanceMath;
import java.util.*;

class Solution {
    private List<Integer> primeNo = new ArrayList<>();

    private void countPrimes(int n) {
        if (n <= 2)
            return;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primeNo.add(i);
            }
        }
    }

    public List<Integer> getPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        int prime = 0;
        int index = 0;
        while (n != 1) {
            prime = primeNo.get(index);
            if (n % prime == 0) {
                factors.add(prime);
                n /= prime;
            } else {
                index++;
            }
        }
       
        return factors;
    }

    public List<List<Integer>> primeFactors(int[] queries) {
        List<List<Integer>> result = new ArrayList<>();
        int max = queries[0]; // Initialize max with the first element of the array

        // Iterate through the array starting from the second element
        for (int i = 1; i < queries.length; i++) {
            if (queries[i] > max) {
                max = queries[i]; // Update max if a larger element is found
            }
        }
        countPrimes(max);
        for (int query : queries) {
            result.add(getPrimeFactors(query));
        }
        System.out.println(result.toString());

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 6 };
        Solution s = new Solution();
        s.primeFactors(arr);
    }
}