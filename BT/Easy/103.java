/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> Result = new ArrayList<>();
        if(root == null) return Result;
        
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        boolean leftToRight = true;
        
        while(!st1.isEmpty() || !st2.isEmpty()){
            List<Integer> newList = new ArrayList<>();
            
            if(leftToRight){
                while(!st1.isEmpty()){
                    TreeNode node = st1.pop();
                    newList.add(node.val);
                    if(node.left != null) st2.push(node.left);
                    if(node.right != null) st2.push(node.right);
                }
            } else {
                while(!st2.isEmpty()){
                    TreeNode node = st2.pop();
                    newList.add(node.val);
                    if(node.right != null) st1.push(node.right);
                    if(node.left != null) st1.push(node.left);
                }
            }
            
            Result.add(newList);
            leftToRight = !leftToRight;
        }
        
        return Result;
    }
}