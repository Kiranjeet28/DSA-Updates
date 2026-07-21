/**19. Binary to Decimal Conversion
Convert a series of binary numbers to decimal and return the maximum decimal value.

Input: Array of binary strings
Output: Maximum decimal value */
class Binary{
    int binaryToDecimal(String binaryStr){
        int decimalValue = 0;
        int base = 1; // 2^0
        for (int i = binaryStr.length() - 1; i >= 0; i--) {
            if (binaryStr.charAt(i) == '1') {
                decimalValue += base;
            }
            base *= 2;
        }
        return decimalValue;
    }
}