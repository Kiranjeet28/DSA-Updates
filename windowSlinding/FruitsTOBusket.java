import java.util.*;

class Solution {
    public int totalFruits(int[] fruits) {
        int n = fruits.length;
        int maxFruits = 0;
        int windowStart = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int fruit = fruits[i];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            // If more than 2 types, shrink window
            while (map.size() > 2) {
                int startFruit = fruits[windowStart];
                map.put(startFruit, map.get(startFruit) - 1);
                if (map.get(startFruit) == 0) {
                    map.remove(startFruit);
                }
                windowStart++;
            }

            maxFruits = Math.max(maxFruits, i - windowStart + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] fruits = { 1, 2, 3, 2, 2 };
        System.out.println(s.totalFruits(fruits)); // ✅ Output: 4
    }
}
