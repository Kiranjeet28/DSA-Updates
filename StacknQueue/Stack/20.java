import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                s1.push(s.charAt(i));
            } else {
                if (s1.empty()) {
                    return false;
                }
                if (s.charAt(i) == '}' && s1.peek() == '{') {
                    s1.pop();
                } else if (s.charAt(i) == ')' && s1.peek() == '(') {
                    s1.pop();
                } else if (s.charAt(i) == ']' && s1.peek() == '[') {
                    s1.pop();
                } else {
                    return false;
                }
            }
        }
        
        return s1.size() == 0;
    }
    public static void main(String[] args) {
    String s = "()[]{}";
    Solution instance = new Solution();
    System.out.println(instance.isValid(s));

    }
}