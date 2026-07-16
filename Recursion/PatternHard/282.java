import java.util.*;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(num, target, result, "", 0, 0, 0);
        return result;
    }

    private void backtrack(String num, int target, List<String> fl, String path, long sum, long lastOperand, int pos) {
        if (pos == num.length()) {
            if (sum == target) fl.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            // Avoid numbers with leading zeros
            if (i != pos && num.charAt(pos) == '0') break;
            String currStr = num.substring(pos, i + 1);
            long currNum = Long.parseLong(currStr);
            if (pos == 0) {
                backtrack(num, target, fl, currStr, currNum, currNum, i + 1);
            } else {
                backtrack(num, target, fl, path + "+" + currStr, sum + currNum, currNum, i + 1);
                backtrack(num, target, fl, path + "-" + currStr, sum - currNum, -currNum, i + 1);
                backtrack(num, target, fl, path + "*" + currStr, sum - lastOperand + lastOperand * currNum, lastOperand * currNum, i + 1);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        String num = "123";
        int target = 6;
        List<String> res = sol.addOperators(num, target);
        System.out.println(res); // Output: [1+2+3, 1*2*3]
    }
}
