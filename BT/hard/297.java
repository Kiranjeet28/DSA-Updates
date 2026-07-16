/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "X,";
        StringBuilder sb = new StringBuilder();
        return serializeHelper(root, sb).toString();
    }

    public StringBuilder serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X,");
            return sb;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
        return sb;
    }
private int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] values = data.split(",");
        return deserializeHelper(values, index);
    }

    public TreeNode deserializeHelper(String[] values, int index) {
        String val = values[index++];
        if (val.equals("X"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(values, index);
        root.right = deserializeHelper(values, index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));