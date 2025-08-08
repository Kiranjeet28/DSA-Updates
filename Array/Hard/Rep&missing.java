//Find the repeating and missing number in an array

import java.util.Arrays;
class Solution{
    public int[] findSolution(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int ArrayTotal =0; int Sum =0;
        int[] result = new int[2];
        for(int num: nums){
            ArrayTotal += num;
            if(map.containsKey(num)){
                result[0] = num; 
            } else {
                map.put(num, 1);
            }
        }
        for(int i=1; i<=nums.length; i++){
            Sum += i;
        }
        result[1] = Sum - (ArrayTotal - result[0]);
        return result;
    }
}