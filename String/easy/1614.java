import java.lang.Math;
class Solution {
    public int maxDepth(String s) {
        int result =0;
        int open =0;
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i)=='('){
                open++;
                result = Math.max(result,open);
            }else if(s.charAt(i)==')'){
                open--;
            }
        }
        return result;
    }
}