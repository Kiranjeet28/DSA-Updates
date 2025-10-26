import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // For A-Z
        int left = 0;
        int maxCount = 0; // max frequency of any char in the current window
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            // If more than k replacements are needed, shrink window
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.characterReplacement("ABAB", 2)); // ✅ Output: 4
        System.out.println(s.characterReplacement("AABABBA", 1)); // ✅ Output: 4
    }
}
