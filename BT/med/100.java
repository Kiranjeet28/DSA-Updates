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
// class Solution {
//     public void Helper(TreeNode root, List<TreeNode> list){
      
//         if(root.left == null ) {
//             list.add(null);
//         }else{

//             Helper(root.left,list);
//         }
//           if(root.right == null ) {
//             list.add(null);
//         }else{

//                    Helper(root.right,list);

//         }
//         list.add(root);
//     }
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         List<TreeNode> pList = new ArrayList<>();

//         List<TreeNode> qList = new ArrayList<>();
//         if(p == null && q == null) return true;
//         if(p == null || q == null) return false;
//         int i = 0 ;
//         Helper(p,pList);
//         Helper(q,qList);
//         if(pList.size() != qList.size()) return false;
//         while(i < pList.size() && i < qList.size()){
//            TreeNode val1 =  pList.get(i);
//            TreeNode val2 =  qList.get(i);
//            // Case 1: one is null, other is not → different
// if (val1 == null && val2 != null) return false;
// if (val1 != null && val2 == null) return false;

// // Case 2: both null → equal, continue
// if (val1 == null && val2 == null){
//     i++;
//     continue;
// };
// // Case 3: both non-null → compare values
// if (val1.val != val2.val) return false;

//             if( val1.val != val2.val){
//                 return false;
//             }
//             i++;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null || q == null) || (p.val != q.val)) return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
}