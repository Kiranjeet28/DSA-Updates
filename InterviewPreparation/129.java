import java.util.*;
import java.lang.Math;

class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        DFS(root, 0);
        return sum;
    }

    public void DFS(TreeNode root, int s) {
        if (root == null) return;

        s = s * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += s;
            return;
        }

        DFS(root.left, s);
        DFS(root.right, s);
    }
}