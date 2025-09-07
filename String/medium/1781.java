class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        // Outer loop for starting index
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // frequency of characters in current substring

            // Inner loop for ending index
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++; // include current char in substring

                // Find max and min frequency
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f > 0) { // only consider characters that appear
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                totalBeauty += (maxFreq - minFreq);
            }
        }
        return totalBeauty;
    }
}
