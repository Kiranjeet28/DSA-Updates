// Time Complexity: O(n), where n is the length of num
class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int end = -1;
        for (int i = n - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if ((c - '0') % 2 == 1) {
                end = i;
                break;
            }
        }
        if (end == -1) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= end; i++) {
            sb.append(num.charAt(i));
        }
        return sb.toString();
    }
}