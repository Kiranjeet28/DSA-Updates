class Solution {
    private void traverseLeft(TreeNode root, Stack<Integer> st) {
        while (root != null) {
            st.push(root.data);
            root = root.left;
        }
    }

    private void traverseRight(TreeNode root, List<Integer> list) {
        while (root != null) {
            list.add(root.data);
            root = root.right;
        }
    }

    public List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<Integer> st = new Stack<>();

        // Go left (excluding root)
        traverseLeft(root.left, st);

        // Left side in correct order
        while (!st.isEmpty()) {
            result.add(st.pop());
        }

        // Root
        result.add(root.data);

        // Go right (excluding root)
        traverseRight(root.right, result);

        return result;
    }
}
