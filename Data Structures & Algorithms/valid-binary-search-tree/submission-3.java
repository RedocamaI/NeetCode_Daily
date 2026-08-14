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

    boolean result(TreeNode root, int mn, int mx) {
        if(root.val <= mn || root.val >= mx)
            return false;
        
        boolean left = true;
        if(root.left != null) {
            if(root.val <= root.left.val)
                return false;
            left = result(root.left, mn, root.val);
        }

        boolean right = true;
        if(root.right != null) {
            if(root.val >= root.right.val)
                return false;
            
            right = result(root.right, root.val, mx);
        }

        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        return result(root, -1000000000, 1000000000);
    }
}
