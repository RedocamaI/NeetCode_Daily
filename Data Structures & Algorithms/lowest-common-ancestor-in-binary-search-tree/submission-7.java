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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);
        int pVal = p.val;
        int qVal = q.val;

        while(!bfs.isEmpty()) {
            TreeNode node = bfs.poll();

            int val = node.val;
            
            if(val > pVal && val > qVal) {
                bfs.add(node.left);
                continue;
            }else if(val < pVal && val < qVal) {
                bfs.add(node.right);
                continue;
            }

            return node;
        }

        return root;
    }
}
