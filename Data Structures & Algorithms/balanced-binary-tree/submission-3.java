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
    boolean balanced = true;
    int getHeightDiff(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftHeight = getHeightDiff(root.left);
        int rightHeight = getHeightDiff(root.right);
        int diff = Math.abs(leftHeight - rightHeight);

        if(diff > 1) {
            balanced = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        getHeightDiff(root);

        return this.balanced;
    }
}
