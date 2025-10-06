class Solution {

    public void storeParenthesis(String str, int open, int close, int n, List<String> ans) {
        if (open == n && close == n) {
            ans.add(str);
            return;
        }

        if (open > n || close > n) {
            return;
        }

        if (close > open) {
            return;
        }

        storeParenthesis(str + ")", open, close + 1, n, ans);
        storeParenthesis(str + "(", open + 1, close, n, ans);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        storeParenthesis("", 0, 0, n, ans);

        return ans;
    }
}