import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode curr = stack.pop();
        if (curr.right != null) {
            pushLeft(curr.right);
        }
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
