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
    TreeNode lca = null;

    public void look(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return;
        
        if(root.val >= p.val && root.val <= q.val) {
            this.lca = root;
            return;
        }

        if(root.val > p.val && root.val > q.val) {
            look(root.left, p, q);
            return;
        }

        look(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.lca = root;
        if(p.val > q.val) {
            look(root, q, p);
            return this.lca;
        }

        look(root, p, q);
        
        return this.lca;
    }
}
