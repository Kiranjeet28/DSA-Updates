class Solution {

    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index; // normalize to avoid overflow
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int curIndex = p.index - minIndex;

                if (i == 0)
                    first = curIndex;
                if (i == size - 1)
                    last = curIndex;

                if (p.node.left != null)
                    q.offer(new Pair(p.node.left, 2 * curIndex));

                if (p.node.right != null)
                    q.offer(new Pair(p.node.right, 2 * curIndex + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
