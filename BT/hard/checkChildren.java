import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    boolean checkChildrenSum(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return true;
        }
        return checkBoolean(root);
    }

    boolean checkBoolean(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int val1 = 0;
        if (root.left != null) {
            val1 = root.left.val;
        }
       
        int val2 = 0;
        if (root.right != null) {
            val2 = root.right.val; // <-- intentional bug for debugging
        }

        // Debug prints
        System.out.println("Visiting Node: " + root.val);
        System.out.println("  Left child value: " + val1);
        System.out.println("  Right child value: " + val2);
        System.out.println("  Sum of children: " + (val1 + val2));
        System.out.println("  Expected (node value): " + root.val);
        System.out.println("  Match: " + (val1 + val2 == root.val));
        System.out.println("----------------------------------");

        return (val1 + val2 == root.val
                && checkBoolean(root.left)
                && checkBoolean(root.right));
    }
}

// public class Main {
//     public static void main(String[] args) {

//         TreeNode root = new TreeNode(3);

//         root.left = new TreeNode(2);
//         root.right = new TreeNode(1);

//         root.left.left = new TreeNode(0);
//         root.left.right = new TreeNode(2);

//         root.right.left = new TreeNode(0);
//         root.right.right = new TreeNode(1);

//         Solution sol = new Solution();
//         boolean result = sol.checkChildrenSum(root);

//         System.out.println("Final Result: " + result);
//     }
// }
