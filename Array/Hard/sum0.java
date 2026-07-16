import java.util.*;
class Solution {
    public int maxLen(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            if (sum == 0) {
                maxLength = i + 1; // Found a subarray from index 0 to i
            } else if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i); // Store the first occurrence of this sum
            }
        }
        return maxLength;
    }
}
