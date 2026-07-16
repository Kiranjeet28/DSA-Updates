import java.util.*;

class Solution {
    public String prefixToInfix(String s) {
        Stack<String> st = new Stack<>();

        // Scan from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // If operand (A-Z or a-z)
            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + ""); // push as string
            }
            // If operator
            else {
                String op1 = st.pop();
                String op2 = st.pop();
                String exp = "(" + op1 + " " + ch + " " + op2 + ")";
                st.push(exp);
            }
        }

        return st.peek();
    }

    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        Solution s = new Solution();
        String infix = s.prefixToInfix(prefix);
        System.out.println("Infix expression: " + infix);
    }
}
