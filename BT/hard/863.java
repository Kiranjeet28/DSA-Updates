import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParent(root, null);
        dfs(target, 0, k);
        return result;
    }

    private void dfs(TreeNode node, int dist, int k) {
        if (node == null || visited.contains(node))
            return;

        visited.add(node);

        if (dist == k) {
            result.add(node.val);
            return;
        }

        // Move downward
        dfs(node.left, dist + 1, k);
        dfs(node.right, dist + 1, k);

        // Move upward
        dfs(parent.get(node), dist + 1, k);
    }

    private void buildParent(TreeNode node, TreeNode par) {
        if (node == null)
            return;
        parent.put(node, par);
        buildParent(node.left, node);
        buildParent(node.right, node);
    }
}
