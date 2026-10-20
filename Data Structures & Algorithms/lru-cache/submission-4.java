class LRUCache {

    private static class Node{
        int key, value;
        Node next, prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private  final int capacity;

    private  final Node head = new Node(0,0);
    private  final Node tail = new Node(0,0);

    private final Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            removeFromFront(node);
            addToEnd(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        /*
        - Check if exists.
        - If exists update else add new.
        */
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeFromFront(node);
            node.value = value;
            addToEnd(node);
            return;
        } else {
            // Check if cache at capacity
            if (map.size() == capacity) {
                Node oldest = head.next;
                map.remove(oldest.key);
                removeFromFront(oldest);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToEnd(newNode);
        }
    }

    private void removeFromFront(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToEnd(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
}
