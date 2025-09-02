class Solution{
    public String longestCommonPrefix(String[] strs){
        String result = strs[0];
        for(String s : strs){
            if(s.length()<result.length()){
                result = s;
            }
        }
        for(String s : strs){

            for(int i =0; i < result.length();i++){
                if(s.charAt(i) != result.charAt(i)){

                System.out.println(s.charAt(i)==result.charAt(i));
                       result = result.substring(0,i);
                System.out.println(result);

                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        String strs[] = {"flower","flow","flight"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}