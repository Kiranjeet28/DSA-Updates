import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        ArrayList<Integer> currList = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : hand) {
            minHeap.add(i);
        }
        while (!minHeap.isEmpty() && currList.size() < groupSize) {
            int currElement = minHeap.poll();
            int prev = currList.size() == 0 ? -1 : currList.get(currList.size() - 1);
            if (prev != -1 && currElement != prev + 1) {
                temp.add(currElement);
            } else {
                currList.add(currElement);
            }

            if (currList.size() == groupSize) {
                currList.clear();
                minHeap.addAll(temp);
                temp.clear();
            }
        }
        if (!minHeap.isEmpty() || !currList.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(s.isNStraightHand(arr, 4));
    }
}