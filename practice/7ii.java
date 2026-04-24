//using Binary Search
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;
      if(m > n ) return findMedianSortedArrays(int[] nums2, int[] nums1);
      
      int low = 0 
      int high = m;
      while(low<= high){
          int partitionX = low + high /2;
          int partitionY = (m+n-1)/2 - partX;
          int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
          int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

          int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
          int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
          
          if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + 
                            Math.min(minRightX, minRightY)) / 2.0;
                }
                // Odd length
                else {
                    return Math.max(maxLeftX, maxLeftY);
                }
          }
           else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            }
            // Move right
            else {
                low = partitionX + 1;
            }
      }
    }
}
