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
    int result = 0;

    public int timeToBurnTree(TreeNode root, int start) {
        buildParent(root, null);
        TreeNode target = findTarget(root, start);
        bfs(target);
        return result;
    }

    private void bfs(TreeNode node) {
        Queue<TreeNode> list = new LinkedList<>();
        list.add(node);
        visited.add(node);
        int time = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = list.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    list.add(curr.left);
                    burned = true;

                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    list.add(curr.right);
                    burned = true;

                }
                TreeNode par = parent.get(curr);
                if (par != null && !visited.contains(par)) {
                    visited.add(par);
                    list.add(par);
                    burned = true;

                }
                if(burned) {
                    time++;
                }
            }

        }
    }
    
    private TreeNode findTarget(TreeNode node, int start) {
        if (node == null)
            return null;
        if (node.val == start)
            return node;

        TreeNode left = findTarget(node.left, start);
        if (left != null)
            return left;

        return findTarget(node.right, start);
    }
    private void buildParent(TreeNode node, TreeNode par) {
        if (node == null)
            return;
        parent.put(node, par);
        buildParent(node.left, node);
        buildParent(node.right, node);
    }
}
