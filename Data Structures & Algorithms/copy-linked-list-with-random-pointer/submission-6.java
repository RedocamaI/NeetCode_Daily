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
        map.put(null, null);
        
        Node org = h1;
        while(org != null) {
            Node node;
            if(!map.containsKey(org))
                map.put(org, new Node(org.val));
            
            if(!map.containsKey(org.next))
                map.put(org.next, new Node(org.next.val));
            map.get(org).next = map.get(org.next);

            if(!map.containsKey(org.random))
                map.put(org.random, new Node(org.random.val));
            map.get(org).random = map.get(org.random);

            org = org.next;
        }

        return map.get(h1);
    }
}
