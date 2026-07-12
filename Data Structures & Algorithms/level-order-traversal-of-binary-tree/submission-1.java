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

class Pair {
    int level;
    TreeNode node;

    Pair(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        Queue<Pair> q = new ArrayDeque<>();
        List<List<Integer>> inorder = new ArrayList<>();
        q.offer(new Pair(1, root));

        while(!q.isEmpty()) {
            int level = q.peek().level;
            TreeNode node = q.peek().node;
            q.poll();

            if(inorder.size() < level) {
                inorder.add(new ArrayList<>(List.of(node.val)));
            }else {
                inorder.get(level-1).add(node.val);
            }

            if(node.left != null)
                q.offer(new Pair(level+1, node.left));
            if(node.right != null)
                q.offer(new Pair(level+1, node.right));
        }

        return inorder;
    }
}
