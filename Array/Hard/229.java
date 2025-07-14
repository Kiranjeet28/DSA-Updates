import java.util.*;
// Brute Force Approach
// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         Map<Integer, Integer> countMap = new HashMap<>();
//         List<Integer> result = new ArrayList<>();
//         int len = nums.length;
//         for(int num : nums) {
//             countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//         }
//         for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//             if (entry.getValue() > len / 3) {
//                 result.add(entry.getKey());
//             }
//         }
//         return result;
//     }
// }

// Optimized Boyer-Moore Voting Algorithm

class Solution{
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int freq1 =0 ;
        int freq2 =0 ;
        int candidate1 = 0;
        int candidate2 = 0;
        int len = nums.length/3;
        for(int n : nums){
            if(freq1 == 0){
                candidate1 = n;
                freq1=1;
                System.out.println("Iteration "+ i+ " candidate1 " + candidate1);
            }
            if(freq2 == 0 ){
                candidate2 = n;
                freq2=1;

                System.out.println("Iteration "+ i+ " candidate2 " + candidate2);

            }
            if(candidate1 == n){
                freq1++;
            }else if(candidate2 == n){
                freq2++;
            }else{
                freq1--;
                freq2--;
            }
        }
        freq1 =0 ;
        freq2 =0 ;
        for(int num : nums){
            if(candidate1 == num){ freq1++;}
            else if(candidate2 == num) {freq2++;}
        }
        if(freq1 > len)
       { result.add(candidate1);}
System.out.println(candidate1+" "+candidate2);

System.out.println(freq1+" "+freq2);
        if(freq2 > len && candidate1 != candidate2)
        {result.add(candidate2);}
        return result;
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,1,1,3,1,4,5,6};
        List<Integer> result = solution.majorityElement(nums);
        System.out.println("Majority elements: " + result);
    }
}