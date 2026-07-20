import java.util.*;

class Solution {

    // -------------------------------------------------------
    // Approach 1: Sorting
    // Time Complexity : O(n log n)
    // Extra Space     : O(1) (excluding output list)
    // -------------------------------------------------------
    List<Integer> nonUniqueSort(int[] arr) {

        List<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            return result;
        }

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1]) {

                // Avoid adding the same duplicate multiple times
                if (result.isEmpty() || result.get(result.size() - 1) != arr[i]) {
                    result.add(arr[i]);
                }
            }
        }

        return result;
    }

    // -------------------------------------------------------
    // Approach 2: HashMap
    // Time Complexity : O(n)
    // Extra Space     : O(n)
    // -------------------------------------------------------
    List<Integer> nonUniqueHashMap(int[] arr) {

        List<Integer> result = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            return result;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Collect duplicates
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    // -------------------------------------------------------
    // Main Method
    // -------------------------------------------------------
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] arr = {1, 2, 2, 3, 4, 4, 5, 2, 4};

        System.out.println("Original Array : " + Arrays.toString(arr));

        System.out.println("Duplicates using Sorting : "
                + obj.nonUniqueSort(arr.clone()));

        System.out.println("Duplicates using HashMap : "
                + obj.nonUniqueHashMap(arr));
    }
}