class LRUCache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            unLink(node);
            addFirst(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            unLink(node);
            addFirst(node);
        } else {
            if (map.size() == capacity) {
                Node remove = tail.prev;
                Node prev = tail.prev.prev;
                prev.next = tail;
                tail.prev = prev;
                map.remove(remove.key);
            }
            Node newNode = new Node(key, value);
            addFirst(newNode);
            map.put(key, newNode);
        }
    }

    private void unLink(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addFirst(Node node) {
        Node next = head.next;
        node.next = next;
        node.prev = head;
        next.prev = node;
        head.next = node;
    }
}
