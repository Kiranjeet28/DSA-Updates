import java.util.*;

class Solution {

    public void rec(List<String> FL, HashMap<Integer,String> hm, int pos,String curr,String arr ) {
        if (curr.length() == arr.length()) {
            FL.add(curr);
            return;
        }
        if (pos >= arr.length() || curr.length() > arr.length())
            return;
        int num = Integer.parseInt(arr.charAt(pos) + "");
        String s = hm.get(num);
        if (s == null) return;
        int index = s.length();
        for (int i = 0; i < index; i++) {
            char c = s.charAt(i);
            rec(FL, hm, pos + 1, curr + c, arr);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> FL = new ArrayList<>();
        if(digits.length() == 0) return FL; 
        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");

        rec(FL,hm,0,"",digits);
        System.out.println(FL);
        return FL;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.letterCombinations("2378");
    }
}
