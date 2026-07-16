import java.util.*;

class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            int a = nums1[i];
            int b = nums2[j];
            
            if (a < b) {
                if (set.add(a)) result.add(a);
                i++;
            } else if (a > b) {
                if (set.add(b)) result.add(b);
                j++;
            } else {
                if (set.add(a)) result.add(a);
                i++;
                j++;
            }
        }

        while (i < nums1.length) {
            if (set.add(nums1[i])) result.add(nums1[i]);
            i++;
        }

        while (j < nums2.length) {
            if (set.add(nums2[j])) result.add(nums2[j]);
            j++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
