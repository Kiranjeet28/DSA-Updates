/**18. Repeated Characters in a String
Identify repeated characters in a string and return the string with duplicates removed.

Input: String (e.g., "hello")
Output: String (e.g., "helo") */
class Solution{
    String removeDuplicates(String str){
        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[26]; // Assuming only lowercase letters
        for (char c : str.toCharArray()) {
            if (!seen[c - 'a']) {
                seen[c - 'a'] = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }
    String removeDuplicatesUsingSet(String str){
        StringBuilder sb = new StringBuilder();
        char prevChar = str.charAt(0);
        sb.append(prevChar);
        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar != prevChar) {
                sb.append(currentChar);
                prevChar = currentChar;
            }
        }
        return sb.toString();
    }
}