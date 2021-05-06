class LRUCache {

    DLinkedNode head;
    DLinkedNode tail;
    Map<Integer, DLinkedNode> cache = new HashMap<>();
    int capacity;
    
    public class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        
        public DLinkedNode() {
            
        }
        
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public void remove(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void add(DLinkedNode node) {
        node.prev = head;
        head.next.prev = node;
        node.next = head.next; 
        head.next = node;
    }
    
    public void moveToHead(DLinkedNode node) {
        remove(node);
        add(node);
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            moveToHead(cache.get(key));
            return cache.get(key).value;
        }
        
        return -1;
    }
     
    public DLinkedNode removeFromTail() {
        DLinkedNode  node = tail.prev;
        tail.prev = node.prev;
        tail.prev.next = tail;
        return node;
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            add(newNode);
            cache.put(key, newNode);
            
            if(cache.size() > capacity) {
                DLinkedNode node = removeFromTail();
                cache.remove(node.key);
            }
        } else {
            DLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */