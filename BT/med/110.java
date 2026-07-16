import java.util.*;

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> post = new Stack<>();
        HashMap<TreeNode, Integer> height = new HashMap<>();

        // Step 1: Create postorder traversal in stack `post`
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            post.push(node);

            if (node.left != null)
                st.push(node.left);
            if (node.right != null)
                st.push(node.right);
        }

        // Step 2: Process nodes from postorder stack
        while (!post.isEmpty()) {
            TreeNode node = post.pop();

            int leftH = node.left != null ? height.get(node.left) : 0;
            int rightH = node.right != null ? height.get(node.right) : 0;

            // Check balance
            if (Math.abs(leftH - rightH) > 1)
                return false;

            // Store height of current node
            height.put(node, Math.max(leftH, rightH) + 1);
        }

        return true; // Tree is balanced
    }
}
