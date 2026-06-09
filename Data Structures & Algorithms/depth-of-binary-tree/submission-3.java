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
    int getMaxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = 1 + getMaxDepth(root.left);
        int rightHeight = 1 + getMaxDepth(root.right);

        return Math.max(leftHeight, rightHeight);
    }

    public int maxDepth(TreeNode root) {
        return getMaxDepth(root);
    }
}
