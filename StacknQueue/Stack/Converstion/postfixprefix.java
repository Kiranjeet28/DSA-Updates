import java.util.*;

class Solution {
    public String PostfixToPrefix(String s) {
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
                String exp = c + op1 + op2 ;
                st.push(exp);
            }
        }

        return st.peek();
    }

   
}
