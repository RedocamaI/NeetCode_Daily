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
    List<TreeNode> nodes = new ArrayList<>();
    void getSubNode(TreeNode root, TreeNode checkNode) {
        if(root == null || checkNode == null)
            return;
        if(root.val == checkNode.val)
            this.nodes.add(root);
        
        getSubNode(root.left, checkNode);
        getSubNode(root.right, checkNode);
    }

    boolean checkSubTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p != null && q == null)
            return false;
        if(p == null && q != null)
            return false;
        if(p.val != q.val)
            return false;
        
        boolean checkLeftSubTree = checkSubTree(p.left, q.left);
        boolean checkRightSubTree = checkSubTree(p.right, q.right);

        return checkLeftSubTree && checkRightSubTree;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        getSubNode(root, subRoot);

        if(this.nodes.isEmpty())
            return false;
        
        for(TreeNode node:this.nodes) {
            if(checkSubTree(node, subRoot))
                return true;
        }
        
        return false;
    }
}
