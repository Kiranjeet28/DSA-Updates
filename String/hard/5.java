class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("Checking center at index: " + i);

            // Odd length palindrome
            int len1 = expandFromCenter(s, i, i);
            System.out.println("Odd length palindrome at " + i + ": " + len1);

            // Even length palindrome
            int len2 = expandFromCenter(s, i, i + 1);
            System.out.println("Even length palindrome at " + i + ": " + len2);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                System.out.println("Updated longest palindrome: start=" + start + ", end=" + end + ", substring=" + s.substring(start, end + 1));
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        System.out.println("Expanding from center: left=" + left + ", right=" + right);
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            System.out.println("Match at left=" + left + ", right=" + right + " (" + s.charAt(left) + ")");
            left--;
            right++;
        }
        System.out.println("Expansion ended: left=" + left + ", right=" + right + ", length=" + (right - left - 1));
        return right - left - 1; // Length of palindrome
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "abbd";
        System.out.println("Input: " + input);
        String result = sol.longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}
