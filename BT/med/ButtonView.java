import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class ButtonView {
    int val;
    int depth;

    ButtonView(int val, int depth) {
        this.val = val;
        this.depth = depth;
    }
}

class Solution {
    Map<Integer, ButtonView> map = new TreeMap<>(); // TreeMap for sorted HD keys

    public List<Integer> bottomView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        dfs(root, 0, 0); // hd = 0, depth = 0

        for (int hd : map.keySet()) {
            list.add(map.get(hd).val);
        }
        return list;
    }

    public void dfs(TreeNode node, int hd, int depth) {
        if (node == null)
            return;

        if (!map.containsKey(hd) || map.get(hd).depth <= depth) {
            map.put(hd, new ButtonView(node.data, depth));
        }

        dfs(node.left, hd - 1, depth + 1);
        dfs(node.right, hd + 1, depth + 1);
    }
}
