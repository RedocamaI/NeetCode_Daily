/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node root) {
        if(root == null)
            return root;
        
        int[] vis = new int[201];
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> bfs = new ArrayDeque<>();
        Node dNode;
        
        bfs.offer(root);
        while(!bfs.isEmpty()) {
            Node cur = bfs.peek();
            vis[cur.val] = 1;
            bfs.poll();
            dNode = map.containsKey(cur.val) ? 
                map.get(cur.val) : new Node(cur.val);
            
            if(!map.containsKey(cur.val))
                map.put(cur.val, dNode);

            List<Node> dNbrs = new ArrayList<>();
            for(Node node : cur.neighbors) {
                Node dNbr;
                if(vis[node.val] == 0 && !map.containsKey(node.val))
                    bfs.offer(node);
                
                if(!map.containsKey(node.val)) {
                    dNbr = new Node(node.val);
                    map.put(node.val, dNbr);
                }

                dNbrs.add(map.get(node.val));
            }

            dNode.neighbors = dNbrs;
        }

        return map.get(root.val);
    }
}