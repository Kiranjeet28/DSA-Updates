import java.util.*;

// O(n)
/*
 * class LRUCache {
 * private final HashMap<Integer, Integer> hmap;
 * private final Deque<Integer> deque; // store keys only
 * private final int capacity;
 * 
 * public LRUCache(int capacity) {
 * this.capacity = capacity;
 * this.hmap = new HashMap<>();
 * this.deque = new ArrayDeque<>();
 * }
 * 
 * public int get(int key) {
 * if (!hmap.containsKey(key)) {
 * return -1;
 * }
 * // Move key to front (most recently used)
 * deque.remove(key); // remove existing occurrence
 * deque.addFirst(key); // add as MRU
 * return hmap.get(key);
 * }
 * 
 * public void put(int key, int value) {
 * if (hmap.containsKey(key)) {
 * // Update value and mark as MRU
 * hmap.put(key, value);
 * deque.remove(key);
 * deque.addFirst(key);
 * return;
 * }
 * 
 * // If capacity reached, evict LRU (from tail)
 * if (hmap.size() == capacity) {
 * Integer lruKey = deque.removeLast(); // remove LRU
 * if (lruKey != null) {
 * hmap.remove(lruKey);
 * }
 * }
 * 
 * // Insert new key-value and mark as MRU
 * hmap.put(key, value);
 * deque.addFirst(key);
 * }
 * }
 */
import java.util.HashMap;

class ListNode {
    int key;
    int value;
    ListNode prev, next;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private final int capacity;
    private final HashMap<Integer, ListNode> map;
    private final ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(0, 0); // dummy head
        this.tail = new ListNode(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        ListNode node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // update existing value
            ListNode node = map.get(key);
            node.value = value;
            remove(node);
            insertToFront(node);
        } else {
            if (map.size() == capacity) {
                // evict least recently used
                ListNode lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            ListNode newNode = new ListNode(key, value);
            insertToFront(newNode);
            map.put(key, newNode);
        }
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
