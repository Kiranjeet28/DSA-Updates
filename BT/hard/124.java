class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    // returns maximum GAIN from this node going DOWN to one side (left OR right)
    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // compute max gain from left and right, ignore negatives
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        // Path including both children (left → node → right)
        int currentPathSum = node.val + leftGain + rightGain;

        // update global max
        maxSum = Math.max(maxSum, currentPathSum);

        // return max gain that can be extended by parent (choose best one side)
        return node.val + Math.max(leftGain, rightGain);
    }
}
