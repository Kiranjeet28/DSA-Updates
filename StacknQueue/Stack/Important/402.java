import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            // Remove larger previous digits when current is smaller
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // If still have k left, remove from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // ✅ Test cases
        System.out.println(s.removeKdigits("1432219", 3)); // "1219"
        System.out.println(s.removeKdigits("10200", 1)); // "200"
        System.out.println(s.removeKdigits("10", 2)); // "0"
        System.out.println(s.removeKdigits("1234567890", 9)); // "0"
        System.out.println(s.removeKdigits("112", 1)); // "11"
        System.out.println(s.removeKdigits("10001", 1)); // "1"
    }
}
