import java.util.*;

class Solution {
    // Function to return precedence of operators
    int prec(char c) {
        if (c == '+' || c == '-')
            return 1;
        if (c == '*' || c == '/')
            return 2;
        if (c == '^')
            return 3;
        return -1;
    }

    public String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If character is operand (a-z, A-Z, or 0-9)
            if (Character.isLetterOrDigit(c)) {
                ans.append(c);
            }

            // If '(', push to stack
            else if (c == '(') {
                st.push(c);
            }

            // If ')', pop until '('
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop(); // remove '('
            }

            // If operator
            else {
                while (!st.isEmpty() && prec(c) <= prec(st.peek())) {
                    if (c == '^' && st.peek() == '^')
                        break; // right-associative check
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }

        // Pop all remaining operators
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.infixToPostfix("(a+b)*c")); // ab+c*
        System.out.println(s.infixToPostfix("a+b*c")); // abc*+
        System.out.println(s.infixToPostfix("a+b*c^d")); // abcd^*+
    }
}
