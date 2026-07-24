/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node h1) {
        if(h1 == null)
            return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        Node org = h1;
        Node h2 = new Node(org.val);
        map.put(org, h2);

        Node node = h2;
        while(node != null) {
            Node nextOrg = org.next;
            Node next = nextOrg != null ? new Node(nextOrg.val) : null;

            map.put(nextOrg, next);
            node.next = next;
            org = org.next;
            node = next;
        }

        node = h2;
        org = h1;
        while(node != null && org != null) {
            node.random = org.random != null ?
                (map.get(org.random) != null ? 
                    map.get(org.random) : new Node(org.random.val))
                : null;
            
            node = node.next;
            org = org.next;
        }

        return h2;
    }
}
