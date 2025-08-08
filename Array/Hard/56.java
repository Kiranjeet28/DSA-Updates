import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the array 
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result =new ArrayList<>();;
        int[] c = intervals[1];
        int min =c[0];
        int max = c[1];
        //Main algo
         for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if(current[0] >= min && current[1] < max){
                min = current[0];
                max = Math.max(max,current[1]);
            }else{
                int r[] = {min,max};
                result.add(r);
                min = current[0];
                max = current[1];
            }

    }
    return result.toArray(new int[result.size()][]);
    }
}
class Main{
    public  void main(String args[]){
        int[][] input = {
            {1, 3}, {2, 6}, {8, 10}, {8, 9}, {9, 11}, {15, 18}, {2, 4}, {16, 17}
        };

        int[][] result = merge(input);

        // Print result
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
