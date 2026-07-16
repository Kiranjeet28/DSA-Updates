import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int WindowStartIndex = 0;
        int WindowSize = 0;
        // hmap to store character & index;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i =0 ;i < n;i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)) {
                WindowStartIndex = Math.max(WindowStartIndex, map.get(a) + 1);
                map.remove(a);
            } 
            map.put(a, i);
            System.out.println("Window Start" + WindowStartIndex+" Window End"+ i);
            WindowSize = Math.max(WindowSize, i - WindowStartIndex + 1);
            System.out.println(WindowSize);
        }
        return WindowSize;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}