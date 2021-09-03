package p146_LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 */
class LRUCache {

    Integer capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // update cache position
            Node node = popNode(key);
            addToTail(node);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // update node value and cache position
            Node node = popNode(key);
            node.value = value;
            addToTail(node);
        } else {
            if (map.size() >= capacity) {
                // remove one node;
                Node removed = popHead();
                map.remove(removed.key);
            }
            // add on new node
            Node newNode = new Node(key, value);
            addToTail(newNode);
            map.put(key, newNode);
        }
    }

    public void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public Node popHead() {
        Node res = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        res.prev = null;
        res.next = null;
        return res;
    }

    public Node popNode(int key) {
        Node res = map.get(key);
        res.prev.next = res.next;
        res.next.prev = res.prev;
        res.prev = null;
        res.next = null;
        return res;
    }

    public class Node {
        public Node prev;
        public Node next;
        public Integer key;
        public Integer value;

        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * <p>
 * class LRUCache extends LinkedHashMap<Integer, Integer>{
 * private int capacity;
 * <p>
 * public LRUCache(int capacity) {
 * super(capacity, 0.75F, true);
 * this.capacity = capacity;
 * }
 * <p>
 * public int get(int key) {
 * return super.getOrDefault(key, -1);
 * }
 * <p>
 * public void put(int key, int value) {
 * super.put(key, value);
 * }
 *
 * @Override protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
 * return size() > capacity;
 * }
 * }
 * <p>
 * class LRUCache extends LinkedHashMap<Integer, Integer>{
 * private int capacity;
 * <p>
 * public LRUCache(int capacity) {
 * super(capacity, 0.75F, true);
 * this.capacity = capacity;
 * }
 * <p>
 * public int get(int key) {
 * return super.getOrDefault(key, -1);
 * }
 * <p>
 * public void put(int key, int value) {
 * super.put(key, value);
 * }
 * @Override protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
 * return size() > capacity;
 * }
 * }
 * <p>
 * class LRUCache extends LinkedHashMap<Integer, Integer>{
 * private int capacity;
 * <p>
 * public LRUCache(int capacity) {
 * super(capacity, 0.75F, true);
 * this.capacity = capacity;
 * }
 * <p>
 * public int get(int key) {
 * return super.getOrDefault(key, -1);
 * }
 * <p>
 * public void put(int key, int value) {
 * super.put(key, value);
 * }
 * @Override protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
 * return size() > capacity;
 * }
 * }
 * <p>
 * class LRUCache extends LinkedHashMap<Integer, Integer>{
 * private int capacity;
 * <p>
 * public LRUCache(int capacity) {
 * super(capacity, 0.75F, true);
 * this.capacity = capacity;
 * }
 * <p>
 * public int get(int key) {
 * return super.getOrDefault(key, -1);
 * }
 * <p>
 * public void put(int key, int value) {
 * super.put(key, value);
 * }
 * @Override protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
 * return size() > capacity;
 * }
 * }
 */

/**
 * class LRUCache extends LinkedHashMap<Integer, Integer>{
 *     private int capacity;
 *
 *     public LRUCache(int capacity) {
 *         super(capacity, 0.75F, true);
 *         this.capacity = capacity;
 *     }
 *
 *     public int get(int key) {
 *         return super.getOrDefault(key, -1);
 *     }
 *
 *     public void put(int key, int value) {
 *         super.put(key, value);
 *     }
 *
 *     @Override
 *     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
 *         return size() > capacity;
 *     }
 * }
 */
