import java.util.Stack;

class Solution {
    public void reverseStack(Stack<Integer> st, Stack<Integer> temp ) {
        if (temp.size() == 0) {
            return;
        }
        int n = temp.peek();
        temp.pop();
        System.out.println("Temp: " + temp + " St: " + st);
        reverseStack(st, temp);
        st.push(n);
    }

    public void reverseStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {
            temp.push(st.peek());
            st.pop();
        }
        reverseStack(st, temp);
        System.out.println(st);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        s.reverseStack(st);
    }
}