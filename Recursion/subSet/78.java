import java.util.*;
import java.lang.Math;

class Solution {
    public List<List<Integer>> rec(int i, int[] arr, List<Integer> current ,List<List<Integer>> FinalList) {
        List<Integer> NextList = new ArrayList<>();
        if (arr.length == i) {
            FinalList.add(current);
            return FinalList;
        }
        NextList.addAll(current);
        NextList.add(arr[i]);
        rec(i + 1, arr, NextList,FinalList);
        rec(i + 1, arr, current, FinalList);
        return FinalList;
    }

    public List<List<Integer>> subsets(int[] nums) {
        int l = nums.length;
        List<Integer> n = new ArrayList<>();
        List<List<Integer>> FinalList = new ArrayList<>();
        System.out.println("List of function " + rec(0, nums, n, FinalList));
        return FinalList;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        Solution s = new Solution();
        s.subsets(arr);
    }
}