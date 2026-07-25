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

    private void traverseForRight(TreeNode node, List<Integer> rightView, int level) {
        if(node == null)
            return;

        if(level == rightView.size()) {
            rightView.add(node.val);
        }

        if(node.right != null) {
            traverseForRight(node.right, rightView, level+1);
        }
        if(node.left != null) {
            traverseForRight(node.left, rightView, level+1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        traverseForRight(root, rightView, 0);

        return rightView;
    }
}
