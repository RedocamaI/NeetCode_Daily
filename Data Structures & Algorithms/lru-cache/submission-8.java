class Node {
    private int key;
    private int val;
    private Node next = null;
    private Node prev = null;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    protected int getKey() {
        return this.key;
    }

    protected void setKey(int key) {
        this.key = key;
    }

    protected int getValue() {
        return this.val;
    }

    protected void setValue(int val) {
        this.val = val;
    }

    protected Node getPrev() {
        return this.prev;
    }

    protected void setPrev(Node prev) {
        this.prev = prev;
    }

    protected Node getNext() {
        return this.next;
    }

    protected void setNext(Node next) {
        this.next = next;
    }
}

class LRUCache {
    int cap;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.tail.setNext(this.head);
        this.head.setPrev(this.tail);
    }

    private void remove(Node node) {
        Node nextNode = node.getNext();
        Node prevNode = node.getPrev();

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
    }
    
    private void insertAtHead(Node node) {
        Node prevHead = this.head.getPrev();

        prevHead.setNext(node);
        node.setPrev(prevHead);

        node.setNext(this.head);
        this.head.setPrev(node);
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node node = map.get(key);
        remove(node);
        insertAtHead(node);

        return node.getValue();
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insertAtHead(node);

            this.map.put(key, node);
            node.setValue(value);

            return;
        }

        // check if we can accomodate new value:
        if(this.map.size() == this.cap) {
            // remove the least recently use node: the tail node
            Node expiredNode = this.tail.getNext();
            
            remove(expiredNode);
            this.map.remove(expiredNode.getKey());
        }

        Node node = new Node(key, value);
        // add the new node to head:
        insertAtHead(node);
        this.map.put(key, node);
    }
}
