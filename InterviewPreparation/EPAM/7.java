import java.util.*;

class Solution {

    public static String check(String st) {

        // Reverse the input string
        st = new StringBuilder(st).reverse().toString();

        int currIndex = 0;
        StringBuilder ans = new StringBuilder();

        while (currIndex < st.length()) {

            // Try 2-digit ASCII value first
            if (currIndex + 2 <= st.length()) {

                int asciiValue = Integer.parseInt(st.substring(currIndex, currIndex + 2));

                if ((asciiValue >= 65 && asciiValue <= 90) || asciiValue == 32) {
                    ans.append((char) asciiValue);
                    currIndex += 2;
                    continue;
                }
            }

            // Otherwise use 3-digit ASCII value
            if (currIndex + 3 <= st.length()) {

                int asciiValue = Integer.parseInt(st.substring(currIndex, currIndex + 3));
                ans.append((char) asciiValue);
                currIndex += 3;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String st = sc.nextLine();

        System.out.println("Decoded Password: " + check(st));
    }
}