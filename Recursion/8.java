class Solution {
    // using recursion
    public int recStringPart(String s, int i, int sign, int res) {
        if (i >= s.length() || s.charAt(i) < '0' || s.charAt(i) > '9') {
            return res * sign;
        }
        int digit = s.charAt(i) - '0';
        if (res > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        res = res * 10 + digit;
        return recStringPart(s, i + 1, sign, res);
    }

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        int res = 0;
        int sign = 1, i = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }
        return recStringPart(s, i, sign, res);
    }

}
