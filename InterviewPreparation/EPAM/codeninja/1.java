// https://www.naukri.com/code360/problems/pair-sum_697295?interviewBundleRedirection=true
import java.io.*;
import java.util.*;

public class Solution {

    public static List<int[]> pairSum(int[] arr, int s) {

        List<int[]> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store frequency
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int i : arr) {

            int val = s - i;

            if (map.containsKey(val) && map.get(val) > 0) {

                // Handle case when both numbers are same
                if (i == val && map.get(i) < 2)
                    continue;

                int[] pair = new int[2];
                pair[0] = Math.min(i, val);
                pair[1] = Math.max(i, val);

                list.add(pair);

                // Reduce frequencies
                map.put(i, map.get(i) - 1);
                map.put(val, map.get(val) - 1);
            }
        }

        return list;
    }

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();

        int sum = s.nextInt();

        List<int[]> result = pairSum(arr, sum);

        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }

        s.close();
    }
}