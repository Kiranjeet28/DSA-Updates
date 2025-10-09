import java.util.*;

class Solution {

    public void rec(List<Integer> FL, int[] arr, int sum,
            int positionOfCurrent) {
        if (positionOfCurrent >= arr.length) {
            FL.add(sum);
            return;
        }
        rec(FL, arr, sum, positionOfCurrent+1);
        sum += arr[positionOfCurrent];
        rec(FL, arr, sum, positionOfCurrent + 1);
        
    }

    public List<Integer> combinationSum2(int[] candidates) {
        List<Integer> setOfLists = new ArrayList<>();
        rec(setOfLists, candidates,  0, 0);
        System.out.println(setOfLists);
        return setOfLists;
    }

    public static void main(String[] args) {
        int arr[] = {5,2,1};
        Solution s = new Solution();
        s.combinationSum2(arr);
    }
}
