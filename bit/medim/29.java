class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        // Bit shifting method
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                a -= (b << i);
                result += (1 << i);
            }
        }

        return negative ? -result : result;
    }
}
/*
while (a >= b) {
    int temp = b;
    int multiple = 1;

    while ((temp << 1) <= a) {
        temp <<= 1;        // double the chunk
        multiple <<= 1;    // track how many times
    }

    a -= temp;             // subtract the biggest chunk
    result += multiple;    // add it to quotient
}
 */