import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    // If p and q are found in different subtrees
    if (left != null && right != null) {
      return root;
    }

    // Otherwise return the found node
    return left != null ? left : right;
  }
}

public class Main {
  public static void main(String[] args) {

    // Build tree: [3,5,1,6,2,0,8,null,null,7,4]
    TreeNode root = new TreeNode(3);

    root.left = new TreeNode(5);
    root.right = new TreeNode(1);

    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);

    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);

    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);

    TreeNode p = root.left; // 5
    TreeNode q = root.right; // 1

    Solution sol = new Solution();
    TreeNode lca = sol.lowestCommonAncestor(root, p, q);

    System.out.println("LCA is: " + lca.val);
  }
}
