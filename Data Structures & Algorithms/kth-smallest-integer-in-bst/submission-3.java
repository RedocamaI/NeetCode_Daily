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
    List<Integer> inorder;

    private void traverseInorder(TreeNode node) {
        if(node == null)
            return;

        traverseInorder(node.left);
        inorder.add(node.val);
        traverseInorder(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.inorder = new ArrayList<>();

        traverseInorder(root);

        return this.inorder.get(k-1);
    }
}
