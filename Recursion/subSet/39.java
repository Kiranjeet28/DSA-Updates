import java.util.*;

class Solution {
  
    public HashSet<List<Integer>> rec(HashSet<List<Integer>> FL, List<Integer> curr, int[] arr, int target,int sum) {
        if (target == sum) {
            if (!FL.contains(curr)) {
                FL.add(curr);
            }
            System.out.println(FL);
            return FL;
        }
        if (sum > target) {
            return FL;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= target) {
                List<Integer> NextList = new ArrayList<>();

                NextList.addAll(curr);
                NextList.add(arr[i]);
                Collections.sort(NextList);
                System.out.println(NextList);
                if (!FL.contains(NextList)) {
                    rec(FL, NextList, arr, target, sum + arr[i]);
                }
            } else {
                break;
            }
        }
        return FL;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> FL = new ArrayList<>();
        if (candidates.length > 1) {

            Arrays.sort(candidates);
        }
        List<Integer> n = new ArrayList<>();
        HashSet<List<Integer>> setOfLists = new HashSet<>();
        rec(setOfLists, n, candidates, target, 0);
        for(List<Integer> hn : setOfLists){
            FL.add(hn);
        }
        System.out.println(FL);
        return FL;

    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2};
        Solution s = new Solution();
        s.combinationSum(arr, 8);
    }
}