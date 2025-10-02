class Solution {
    public int minBitFlips(int start, int goal) {
          long a = Math.abs((long) start);
        long b = Math.abs((long) goal);
        int sum =0;
        int position =0;
        for (int i = 31; i >= 0; i--) {
            if (((a >> position) & 1) != ((b >> position) & 1)) {
                sum++;
            }
            position++;
        }
        return sum;
    }System.out.println((a >> position) + "\n");
        System.out.println(b >> position);
    public static void main(String[] args) {
        Solution s = new Solution();
       s.minBitFlips(4,3);
    }
}