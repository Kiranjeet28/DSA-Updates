import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] previousTemp = new int[n];
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            previousTemp[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }
        int temp;
        for (int i = 0; i < n; i++) {

            temp =  previousTemp[i] - i ;
            if( temp < 0){
                ans[i]=0;
            } else {
                ans[i]=temp;
            }
            System.out.println(ans[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] temp  = { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        
        System.out.println(s.dailyTemperatures(temp).toString());
    }
}