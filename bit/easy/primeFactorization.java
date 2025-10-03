import java.util.*;
class Solution {
        public List<Integer> getPrimeFactors(int n) {
            List<Integer> factors = new ArrayList<>();
            while(n % 2 == 0) {
                factors.add(2);
                n /= 2;
            }
            for(int i = 3; i <= Math.sqrt(n); i += 2) {
                while(n % i == 0) {
                    factors.add(i);
                    n /= i;
                }
            }
            if(n > 1) {
                factors.add(n);
            }
            return factors;
        }
        public List<List<Integer>> primeFactors(int[] queries) {
            List<List<Integer>> result = new ArrayList<>();
            for(int query : queries) {
                result.add(getPrimeFactors(query));
            }
            return result;  
        }
}