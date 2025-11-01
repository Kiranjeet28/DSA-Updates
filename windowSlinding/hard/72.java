import java.util.HashMap;
import java.util.Objects;

class Solution {

    // ✅ Safely compare two frequency maps
    private Boolean checkFreq(HashMap<Character, Integer> h1, HashMap<Character, Integer> h2, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int freq1 = h1.getOrDefault(c, 0);
            int freq2 = h2.getOrDefault(c, 0);
            if (freq1 > freq2) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> h1 = new HashMap<>(); // target freq
        HashMap<Character, Integer> h2 = new HashMap<>(); // current window freq
        int i = 0, j = 0; // window boundaries
        int min = Integer.MAX_VALUE; // min length
        int r = 0, l = 0;
        int bestL = 0, bestR = 0;

        // ✅ store freq of t
        for (int k = 0; k < t.length(); k++) {
            char c = t.charAt(k);
            h1.put(c, h1.getOrDefault(c, 0) + 1);
        }

        // ✅ sliding window
        for (r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);

            if (h1.containsKey(curr)) {
                h2.put(curr, h2.getOrDefault(curr, 0) + 1);
            }

            // ✅ check if current window satisfies all chars
            while (checkFreq(h1, h2, t)) {
                int currLen = r - l + 1;
                if (currLen < min) {
                    min = currLen;
                    bestL = l;
                    bestR = r;
                }

                // shrink from left
                char leftChar = s.charAt(l);
                if (h2.containsKey(leftChar)) {
                    h2.put(leftChar, h2.get(leftChar) - 1);
                    if (h2.get(leftChar) == 0) {
                        h2.remove(leftChar);
                    }
                }
                l++;
            }
        }

        // ✅ no valid window
        if (min == Integer.MAX_VALUE)
            return "";

        // ✅ substring end should be +1
        return s.substring(bestL, bestR + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC")); // ✅ Output: "BANC"
    }
}
// without time exceeded 
import java.util.HashMap;

class Solution {

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> h1 = new HashMap<>(); // target freq
        HashMap<Character, Integer> h2 = new HashMap<>(); // current window freq
        int required = 0; // total unique chars needed
        int formed = 0; // how many chars currently matched

        // build target freq map
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            h1.put(c, h1.getOrDefault(c, 0) + 1);
        }
        required = h1.size();

        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;
        int bestL = 0, bestR = 0;

        while (r < s.length()) {
            char curr = s.charAt(r);

            if (h1.containsKey(curr)) {
                h2.put(curr, h2.getOrDefault(curr, 0) + 1);

                // when a char matches required frequency
                if (h2.get(curr).intValue() == h1.get(curr).intValue()) {
                    formed++;
                }
            }

            // try to shrink when all required chars are matched
            while (formed == required && l <= r) {
                int currLen = r - l + 1;
                if (currLen < min) {
                    min = currLen;
                    bestL = l;
                    bestR = r;
                }

                char leftChar = s.charAt(l);
                if (h1.containsKey(leftChar)) {
                    h2.put(leftChar, h2.get(leftChar) - 1);
                    if (h2.get(leftChar) < h1.get(leftChar)) {
                        formed--; // lost a valid match
                    }
                }
                l++;
            }

            r++;
        }

        if (min == Integer.MAX_VALUE)
            return "";
        return s.substring(bestL, bestR + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC")); // ✅ Output: BANC
    }
}
