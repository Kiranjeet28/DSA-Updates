import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;

        // Step 1: count frequency
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Step 2: find the maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Step 3: count how many tasks have that max frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq)
                maxCount++;
        }

        // Step 4: calculate the minimum intervals
        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * Math.max(0, partLength);
        int availableTasks = tasks.length - maxFreq * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        char[] task = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        Solution s = new Solution();
        System.out.println("Total time: " + s.leastInterval(task, n));
    }
}
