import java.util.*;
//rewrite for revision 
class Solution {
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length() - 1) {
            result.add(new ArrayList<>(path));
        }
        for (int end = start + 1; end <= s.length(); end++) {
            //split string 
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end));
                // Recur to find other partitions
                backtrack(s, end, path, result);
                // Backtrack to explore other partitions
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
       
        Solution solution = new Solution();
        solution.partition("racecar");
    }
}