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
    int k;
    int kthSmallestNode;

    private void getKthSmallest(TreeNode node) {

        if(node == null)
            return;
        
        getKthSmallest(node.left);
        this.k--;

        if(this.k == 0) {
            this.kthSmallestNode = node.val;
            return;
        }

        if(this.k > 0) {
            getKthSmallest(node.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.kthSmallestNode = 0;

        getKthSmallest(root);

        return this.kthSmallestNode;
    }
}
