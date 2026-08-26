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
    Map<Integer, Integer> inMap;
    Map<Integer, Integer> existingNodes;
    int[] preorder;
    int[] inorder;
    int ind;
    int n;

    private TreeNode makeTree(int l, int m, int r) {
        if(ind >= n)
            return null;
        if(!(l <= m && m <= r))
            return null;

        TreeNode node = new TreeNode(inorder[m], null, null);
        ind++;
        
        if(l < m) {
            node.left = makeTree(l, inMap.get(preorder[ind]), m-1);
        }
        if(m < r) {
            node.right = makeTree(m+1, inMap.get(preorder[ind]), r);
        }

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.ind = 0;
        this.n = preorder.length;
        this.preorder = preorder;
        this.inorder = inorder;

        this.inMap = new HashMap<>();
        int l = inorder.length;
        for(int i=0;i<l;i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode node = makeTree(0, inMap.get(preorder[0]), n-1);

        return node;
    }
}
