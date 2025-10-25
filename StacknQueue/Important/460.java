import java.util.HashMap;

class ListNode {
    int key;
    int value;
    int frequency;
    ListNode prev, next;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}

class LFUCache {
    private final int capacity;
    private final HashMap<Integer, ListNode> map;
    private final ListNode head, tail;

    public LFUCache(int capacity) {
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
        node.frequency++;
        reposition(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            node.frequency++;
            reposition(node);
        } else {
            if (map.size() == capacity) {
                // Evict least frequently used (head.next)
                ListNode lfu = head.next;
                remove(lfu);
                map.remove(lfu.key);
            }
            ListNode newNode = new ListNode(key, value);
            insertByFrequency(newNode);
            map.put(key, newNode);
        }
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Remove and reinsert in correct frequency order
    private void reposition(ListNode node) {
        remove(node);
        insertByFrequency(node);
    }

    // Insert node at correct position (ascending frequency)
    private void insertByFrequency(ListNode node) {
        ListNode temp = head.next;
        while (temp != tail && temp.frequency <= node.frequency) {
            temp = temp.next;
        }

        node.next = temp;
        node.prev = temp.prev;
        temp.prev.next = node;
        temp.prev = node;
    }

    private void printLinkedList() {
        System.out.print("LinkedList: ");
        ListNode current = head.next;
        while (current != tail) {
            System.out.print("[key=" + current.key + ", val=" + current.value + ", freq=" + current.frequency + "] ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.get(1); // increases freq(1)
        lfu.put(3, 3); // evicts 2
        lfu.get(3);
        lfu.put(4, 4); // evicts 1
        lfu.get(1);
        lfu.get(3);
        lfu.get(4);
    }
}
