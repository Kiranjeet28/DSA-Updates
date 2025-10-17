import java.util.*;

class Solution {
    public String prefixToPostfix(String s) {
        Stack<String> st = new Stack<>();

        // Scan prefix from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            // If operand
            if (Character.isLetterOrDigit(c)) {
                st.push(c + "");
            }
            // If operator
            else {
                String op1 = st.pop();
                String op2 = st.pop();
                String exp = op1 + op2 + c;
                st.push(exp);
            }
        }

        return st.peek();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String prefix = "*-A/BC-/AKL";
        String postfix = s.prefixToPostfix(prefix);

        System.out.println("Prefix: " + prefix);
        System.out.println("Postfix: " + postfix);
    }
}
