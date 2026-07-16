import java.util.*;

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (open > 0) {
                    result.append('(');
                }
                open++;
            } else {
                open--;
                if (open > 0) {
                    result.append(')');
                }
            }
        }
        return result.toString();
    }
}