class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // Both null - symmetric
        if (left == null && right == null)
            return true;

        // One null or mismatching values - not symmetric
        if (left == null || right == null || left.val != right.val)
            return false;

        // Compare outer pairs and inner pairs
        return isMirror(left.left, right.right) &&
                isMirror(left.right, right.left);
    }
}
