import java.util.*;
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
    Map<Integer, Integer> map = new TreeMap<>(); 

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        dfs(root, 0);
        for (int i : map.keySet()) {
            list.add(map.get(i));
        }
        return list;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        map.put(depth, root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
    
}