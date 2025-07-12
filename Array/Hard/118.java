import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> previousRow = new ArrayList<>();
        if (numRows == 1){
            row.add( 1);
            list.add(row);
        }
        else if (numRows == 2) {
            // Add first row [1]
            row.add(1);
            list.add(new ArrayList<>(row));
            // Add second row [1, 1]
            row.clear();
            row.add(1);
            row.add(1);
            list.add(new ArrayList<>(row));
        
        }else{
            // add first row [1]
                   row.add(1);
            list.add(new ArrayList<>(row));
            // Add second row [1, 1]
            row.clear();
            row.add(1);
            row.add(1);
            list.add(new ArrayList<>(row));
            //previousRow add last row;
            previousRow = new ArrayList<>(row);
            row.clear();
            // Add subsequent rows
            for (int i = 2; i < numRows; i++) {
                row.add(1); // Start with 1

                for (int j = 1; j < i; j++) {
                    row.add(previousRow.get(j - 1) + previousRow.get(j));
                }

                row.add(1); // End with 1
                previousRow = new ArrayList<>(row);
                list.add(new ArrayList<>(row));
                row.clear();
            }
        }
        return list;
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle = solution.generate(5);
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}