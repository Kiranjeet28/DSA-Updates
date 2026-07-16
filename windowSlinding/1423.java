class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + cardPoints[i];
        }
        int maxScore = 0;
        for (int i = 0; i <= k; i++) {
            int left = prefix[i];
            int right = prefix[n] - prefix[n - (k - i)];
            maxScore = Math.max(maxScore, left + right);
        }
        return maxScore;
    }
}