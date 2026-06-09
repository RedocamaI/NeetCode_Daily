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
    int diameter = 0;
    int getDiameter(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = 1 + getDiameter(root.left);
        int rightHeight = 1 + getDiameter(root.right);

        this.diameter = Math.max(this.diameter, leftHeight + rightHeight - 1);
        return Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);

        return this.diameter - 1;
    }
}
