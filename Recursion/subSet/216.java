import java.util.*;

class Solution {

    public void rec(List<List<Integer>> FL, List<Integer> curr, int k, int target, int sum,
            int positionOfCurrent) {
        if (sum == target && curr.size() == k) {
            FL.add(new ArrayList<>(curr)); // HashSet prevents duplicates automatically
            return;
        }
        if (sum > target || curr.size() >= k)
            return;

        int index = 10;
        if (target < 10) {
            index = target;
        }
        for (int i = positionOfCurrent; i < index; i++) {
            curr.add(i);
            rec(FL, curr, k, target, sum + i, i + 1);
            curr.remove(curr.size() - 1);

        }
    }

    public List<List<Integer>> combinationSum3(int k , int n) {
        List<List<Integer>> FL = new ArrayList<>();
        rec(FL, new ArrayList<>(), k, n, 0, 1);
        System.out.println(FL);
        return FL;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.combinationSum3(3, 9);
    }
}
