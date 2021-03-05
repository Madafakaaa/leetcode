package p146_LRUCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class LRUCache {

    private Queue<Integer> queue;
    private Map<Integer, Integer> map;
    private Integer limit;

    public LRUCache(int capacity) {
        this.limit = capacity;
        queue = new LinkedList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
        }
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
            map.put(key, value);
        } else {
            if (queue.size() >= limit) map.remove(queue.poll());
            queue.add(key);
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */