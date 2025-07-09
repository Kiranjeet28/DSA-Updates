import java.util.ArrayList;
class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> positive = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            }
        }
        ArrayList<Integer> negative = new ArrayList<>();
        for (int num : nums) {
            if (num < 0) {
                negative.add(num);
            }
        }
        System.out.println(positive);
        System.out.println(negative);
        ArrayList<Integer> result = new ArrayList<>();
        int pos = 0, neg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result.add(positive.get(pos++));
            } else {
                result.add(negative.get(neg++));
            }
        }

        int[] array = result.stream().mapToInt(i -> i).toArray();

        return array;
    }
}

