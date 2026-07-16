/* Minimum Occurrence
Find the character in a string that appears the fewest times. The string contains only ASCII characters (a-z, A-Z, 0-9), and case matters. In case of a tie, return the character that appears first.

Input: String (e.g., "cdadcda")
Output: Character (e.g., "c") 
*/
import java.util.*;
import java.util.Scanner;
class Solution{
    public static char check(String st){
        HashMap<Character, Integer> hmap = new HashMap<>();

        for (int i = 0; i < st.length(); i++) {
    char ch = st.charAt(i);
    hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
}

          int min = Integer.MAX_VALUE;
        char ans = st.charAt(0);

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);

            if (hmap.get(ch) < min) {
                min = hmap.get(ch);
                ans = ch;
            }
        }

        return ans;
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
         System.out.println("Enter a String: ");
        String st = s.nextLine();
        System.out.println("Result " + check(st));
    }
}
