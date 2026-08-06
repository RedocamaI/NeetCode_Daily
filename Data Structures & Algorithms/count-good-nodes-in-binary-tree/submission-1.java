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
    private int num;

    private void getNumberOfGoodNodes(TreeNode root, int greatest) {
        if(root == null)
            return;
        if(root.val >= greatest) {
            this.num++;
        }

        getNumberOfGoodNodes(root.right, Math.max(root.val, greatest));
        getNumberOfGoodNodes(root.left, Math.max(root.val, greatest));
    }

    public int goodNodes(TreeNode root) {
        this.num = 0;

        getNumberOfGoodNodes(root, root.val);

        return this.num;
    }
}
