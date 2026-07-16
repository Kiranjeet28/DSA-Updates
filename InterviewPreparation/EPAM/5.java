/*5. Anagram Check
Check if two strings are anagrams of each other.Programming

Input: Two strings (e.g., "listen", "silent")
Output: Boolean (e.g., True) */
import java.util.*;
class Solution{
    public boolean check(String st , String v){
        if(st.length() != v.length()) return false;
        
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0 ; i < st.length() ; i++ ){
            char curr = st.charAt(i);

            hmap.put(curr , hmap.getOrDefault(curr,0) + 1 );
        }

        for(int j = 0 ; j < v.length() ; j++ ){
            char curr = v.charAt(j);
            if(hmap.containsKey(curr) && hmap.get(curr) > 0 ){
                hmap.put(curr , hmap.getOrDefault(curr,0) - 1 );
            }else return false;
        }
        return true;
    }
    public void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your String : ");
        String st = s.nextLine();
        System.out.println("Enter your String 2 ");
        String v = s.nextLine();
        Solution j = new Solution(); 
        boolean result = j.check(st,v );
        
        System.out.println(result);
    }
}