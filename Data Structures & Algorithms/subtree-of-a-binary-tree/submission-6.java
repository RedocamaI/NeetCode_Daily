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
    public boolean checkIfSubTree(TreeNode root, TreeNode sub) {
        Queue<List<TreeNode>> q = new LinkedList<>();
        q.add(new ArrayList<>(List.of(root, sub)));

        while(!q.isEmpty()) {
            TreeNode leftNode = q.peek().get(0);
            TreeNode rightNode = q.peek().get(1);

            q.poll();
            if((leftNode == null) != (rightNode == null))
                return false;
            if(leftNode == null && rightNode == null)
                continue;
            if(leftNode.val != rightNode.val)
                return false;
            
            q.add(new ArrayList<>(Arrays.asList(leftNode.left, rightNode.left)));
            q.add(new ArrayList<>(Arrays.asList(leftNode.right, rightNode.right)));
        }

        return true;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        if(subRoot == null)
            return true;
        
        if(checkIfSubTree(root, subRoot))
            return true;
        
        return isSubtree(root.left, subRoot) ||
            isSubtree(root.right, subRoot);
    }
}
