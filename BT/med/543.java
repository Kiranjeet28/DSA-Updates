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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> post = new Stack<>();
        HashMap<TreeNode, Integer> diameter = new HashMap<>();

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
        int maxDiameter = 0;
        while (!post.isEmpty()) {
            TreeNode node = post.pop();

            int leftH = node.left != null ? diameter.get(node.left) : 0;
            int rightH = node.right != null ? diameter.get(node.right) : 0;
            
            int localDiameter = leftH + rightH;
            maxDiameter = Math.max(maxDiameter, localDiameter);
          System.out.println(Math.max(leftH, rightH));
            // Store height of current node
            diameter.put(node, Math.max(leftH, rightH) + 1);
        }
        
        return maxDiameter; // Tree is balanced
    }
}
