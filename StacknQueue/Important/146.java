import java.util.*;

class LRUCache {
    private final HashMap<Integer, Integer> hmap;
    private final Deque<Integer> deque; // store keys only
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hmap = new HashMap<>();
        this.deque = new ArrayDeque<>();
    }

    public int get(int key) {
        if (!hmap.containsKey(key)) {
            return -1;
        }
        // Move key to front (most recently used)
        deque.remove(key); // remove existing occurrence
        deque.addFirst(key); // add as MRU
        return hmap.get(key);
    }

    public void put(int key, int value) {
        if (hmap.containsKey(key)) {
            // Update value and mark as MRU
            hmap.put(key, value);
            deque.remove(key);
            deque.addFirst(key);
            return;
        }

        // If capacity reached, evict LRU (from tail)
        if (hmap.size() == capacity) {
            Integer lruKey = deque.removeLast(); // remove LRU
            if (lruKey != null) {
                hmap.remove(lruKey);
            }
        }

        // Insert new key-value and mark as MRU
        hmap.put(key, value);
        deque.addFirst(key);
    }
}
