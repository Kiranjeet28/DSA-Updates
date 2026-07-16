import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
class Solution {
    public List<Integer> count_NGE(int[] arr, int[] indices) {
        List<Integer> l = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < indices.length; i++) {
            for (int j = arr.length-1 ; j >= indices[0]; j--) {
                if (arr[indices[i]] < arr[j]) {
                    st.push(arr[j]);
                }
            }
            l.add(st.size());
            st.removeAll(st);
        }

        System.out.println(l);
        return l;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 1 }, indices = { 0, 3 };
        Solution s = new Solution();
        s.count_NGE(arr, indices);
    }
}