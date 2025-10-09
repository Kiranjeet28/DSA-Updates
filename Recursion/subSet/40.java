import java.util.*;

class Solution {

    public void rec(HashSet<List<Integer>> FL, List<Integer> curr, int[] arr, int target, int sum,
            int positionOfCurrent) {
        if (sum == target) {
            FL.add(new ArrayList<>(curr)); // HashSet prevents duplicates automatically
            return;
        }

         for (int i = positionOfCurrent; i < arr.length; i++)  {
            // 🧩 Skip duplicates at the same recursion depth
            if (i > positionOfCurrent && arr[i] == arr[i - 1])
                continue;

            // 🚫 Stop if adding arr[i] exceeds target
            if (sum + arr[i] > target)
                break; 
            System.out.println(curr );
            curr.add(arr[i]);
            rec(FL, curr, arr, target, sum + arr[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> setOfLists = new HashSet<>();
        rec(setOfLists, new ArrayList<>(), candidates, target, 0, 0);

        // Convert HashSet to List
        List<List<Integer>> FL = new ArrayList<>(setOfLists);
        System.out.println(FL);
        return FL;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Solution s = new Solution();
        s.combinationSum2(arr, 45);
    }
}
