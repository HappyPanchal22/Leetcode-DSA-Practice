/**
 * 146. LRU Cache
 * Difficulty: Medium
 * 
 * Time Complexity: O(1) for get and put
 * Space Complexity: O(capacity)
 * 
 * Tags: HashMap, Linked List, Design, Doubly-Linked List
 */

class LRUCache {
    class Node {
    int key;
    int value;
    Node prev;
    Node next;
    
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    }
    private HashMap<Integer, Node> cache;   //key -> Node
    private int capacity;
    private Node head;    // Most recently used (dummy)
    private Node tail;    // Least recently used (dummy)

    public LRUCache(int capacity) {
       this.cache = new HashMap<>();
       this.capacity = capacity;
       //dummy nodes (they help avoid null checks)
       head = new Node(0,0);  //dummy head
       tail = new Node(0,0);  //dummy tail

       head.next = tail;
       tail.prev = head;
    }

    private void addToHead(Node node){
        // Step 1: node connects to head's next
        node.next = head.next;
        node.prev = head;

        // Step 2: Update head's next to point back to node
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node){
        removeNode(node);   // Remove from current position
        addToHead(node);    // Add to head (most recent)
    }

    private Node removeTail(){
        Node lru = tail.prev;  // The LRU node
        removeNode(lru);      // Remove it
        return lru;          // Return it so we know which key to remove from HashMap
    }
    
    public int get(int key) {
        Node node = cache.get(key);

        if(node == null) return -1;

        moveToHead(node);

        return node.value; 
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        // Case 1: Key already exists - update it
        if(node != null){
            node.value = value;    //Update the value
            moveToHead(node);     //Move to most recent
            return;
        }
        // Case 2: New key - need to add it
        Node newNode = new Node(key, value);
        //Add to HashMap
        cache.put(key, newNode);
        // Add to head of linked list (most recent)
        addToHead(newNode);
         // Check if we exceeded capacity
        if(cache.size() > capacity){
            Node lru = removeTail();
            cache.remove(lru.key); // ← Remove by the LRU node's key
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
