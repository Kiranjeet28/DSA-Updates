class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading whitespace
        int sign = 1, i = 0;
        long res = 0; // Using long to handle overflow cases

        if (s.length() == 0) return 0;

        // Check for sign
        if (s.charAt(0) == '-') { sign = -1; i++; }
        else if (s.charAt(0) == '+') { i++; }

        // Process numerical characters
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break; // Stop at non-numeric character

            res = res * 10 + (ch - '0'); // Convert char to number
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE; // Handle overflow
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int) (sign * res);
    }
}

/* What is learn from it 
1. String Trimming: The use of `trim()` to remove leading and trailing whitespace is a common practice when processing strings.
2. ASCII Value Manipulation: Converting characters to their numeric values by subtracting the ASCII value of '0' is a fundamental technique in character processing. i.e 96 = 0  . 
3. Handle Without Loop: The solution can be implemented without an explicit loop by using string manipulation methods to extract the sign, number, and any non-numeric characters.