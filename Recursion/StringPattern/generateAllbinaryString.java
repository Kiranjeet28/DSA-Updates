import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> rec(int n, int i, List<String> finalList, String curr) {
        if (n == i) {
            // check
            int checkFor1 = 0;
        
            for (int j = 1; j < curr.length(); j++) {
                System.out.println("char at "+ curr.charAt(j));
                if(curr.charAt(j-1) == '1' && curr.charAt(j) == '1'){
                    checkFor1++;
                }
            }
            if(checkFor1 < 1){
                finalList.add(curr);
            }
            return finalList;
        }
        
        rec(n, i + 1, finalList, curr + 0);
        rec(n, i + 1, finalList, curr + 1);
        return finalList;
        
    }

    public List<String> generateBinaryStrings(int n) {
        List<String> finalList = new ArrayList<>();
        rec(n, 0, finalList, "");
        System.out.println("Final List = " + finalList);
        return finalList;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateBinaryStrings(4);
    }
}