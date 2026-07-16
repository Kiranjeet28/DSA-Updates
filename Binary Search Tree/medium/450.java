class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node found

            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }
            // Case 2: No right child
            else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            else {
                TreeNode successor = findMin(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
    }

    // Find minimum value node in a BST
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
