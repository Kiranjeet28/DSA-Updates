class Solution {

    private void Helper(TreeNode node, PriorityQueue<int[]> minHeap, int row, int col) {
        if (node == null) return;

        minHeap.add(new int[]{node.val, row, col});

        Helper(node.left, minHeap, row + 1, col - 1);
        Helper(node.right, minHeap, row + 1, col + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> {
                if (a[2] != b[2]) return a[2] - b[2];     // col first
                if (a[1] != b[1]) return a[1] - b[1];     // row next
                return a[0] - b[0];                       // value last
            });

        List<List<Integer>> result = new ArrayList<>();

        Helper(root, minHeap, 0, 0);

        // group by col
        while (!minHeap.isEmpty()) {

            int col = minHeap.peek()[2];
            List<Integer> list = new ArrayList<>();

            while (!minHeap.isEmpty() && minHeap.peek()[2] == col) {
                int[] arr = minHeap.poll();
                list.add(arr[0]);
            }

            result.add(list);
        }

        return result;
    }
}
