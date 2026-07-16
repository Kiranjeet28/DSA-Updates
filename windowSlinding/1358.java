class Solution {
    public int numberOfSubstrings(String s) {
        int subArray = 0;
        int left = 0;
        int[] freq = new int[3]; // For 'a', 'b', 'c'
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            subArray += left;
        }
        return subArray;
    }
}