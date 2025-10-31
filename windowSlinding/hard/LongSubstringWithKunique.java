class Solution {
    public int longestKSubstr(String s, int k) {
        int max = -1;
        int left = 0;
        int[] freq = new int[26];
        int dis = 0; // distinct characters count

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'a';

            // add current character
            if (freq[idx] == 0)
                dis++;
            freq[idx]++;

            // shrink window until distinct <= k
            while (dis > k) {
                int leftIdx = s.charAt(left) - 'a';
                freq[leftIdx]--;
                if (freq[leftIdx] == 0)
                    dis--;
                left++;
            }

            // if exactly k distinct, update max
            if (dis == k) {
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestKSubstr("gxmht", 3)); // ✅ Output: 3
    }
}
