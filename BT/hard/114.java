import java.util.List;
import java.util.ArrayList;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        helper(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;       
            prev.right = curr;
        }
    }

    public void helper(TreeNode node) {
        if (node == null)
            return;
        list.add(node);
        helper(node.left);
        helper(node.right);
    }
}

// optimized 
class Solution {
    public TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}