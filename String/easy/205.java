class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sIndex = new int[256];
        int[] tIndex = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (sIndex[c1] != tIndex[c2]) return false;

            sIndex[c1] = i + 1;
            tIndex[c2] = i + 1;
        }
        return true;
    }
}
