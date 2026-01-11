import java.util.*;

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
    HashSet<Integer> list = new HashSet<>();

    public boolean move(TreeNode node, int val) {
        int findVal = val - node.val;
        if (list.contains(findVal))
            return true;
        list.add(node.val);
        System.out.println(list + " at node " + node.val);
        if (node.left != null && move(node.left, val))
            return true;
        if (node.right != null && move(node.right, val))
            return true;
        return false;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return true;
        return move(root, k);
    }
}