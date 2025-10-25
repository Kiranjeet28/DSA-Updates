
class Solution {
    public int longestOnes(int[] nums, int k) {
        int WindowSize = 0;
        int countZero = 0;
        int WindowStartIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            }
            System.out.println("count of Zero"+countZero);
            if (countZero > k) {
                int temp = WindowStartIndex;
                while (nums[temp] != 0 && temp != nums.length -1) {
                    temp++;   
                }
                WindowStartIndex = temp + 1;
                System.out.println("Window start Index"+ WindowStartIndex);
                countZero--;
            }
            WindowSize = Math.max(WindowSize, i - WindowStartIndex + 1);

        }
        return WindowSize;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(s.longestOnes(arr, 3));
    }  
}