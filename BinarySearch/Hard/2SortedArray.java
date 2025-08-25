class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        // Always make 'a' the smaller array
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }

        int n = a.length;
        int m = b.length;

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int midX = (low + high) / 2;
            int midY = k - midX;

            int leftA = (midX == 0) ? Integer.MIN_VALUE : a[midX - 1];
            int rightA = (midX == n) ? Integer.MAX_VALUE : a[midX];

            int leftB = (midY == 0) ? Integer.MIN_VALUE : b[midY - 1];
            int rightB = (midY == m) ? Integer.MAX_VALUE : b[midY];

            // Correct partition found
            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            }
            // Move left in a
            else if (leftA > rightB) {
                high = midX - 1;
            }
            // Move right in a
            else {
                low = midX + 1;
            }
        }

        return -1; // Should not reach here
    }
}
