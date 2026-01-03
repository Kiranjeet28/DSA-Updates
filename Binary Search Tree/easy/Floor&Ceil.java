
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null, right = null }
}

class Solution {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> result = new ArrayList<>();
        findFloorCeil(root, key);
        if (min == Integer.MAX_VALUE) {
            result.add(-1);
        } else {
            result.add(min);
        }
        if (max == Integer.MIN_VALUE) {
            result.add(-1);
        } else {
            result.add(max);
        }
        return result;
    }
    public void findFloorCeil(TreeNode root, int key) {
        if (root == null) {
            return;
        }
        if (root.data == key) {
            min = key;
            max = key;
            return;
        } else if (root.data < key) {
            min = Math.min(min, root.data);
            findFloorCeil(root.right, key);
        } else {
            max = Math.max(max, root.data);
            findFloorCeil(root.left, key);
        }
    }
}