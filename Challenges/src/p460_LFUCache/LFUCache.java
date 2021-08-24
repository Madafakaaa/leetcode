package p460_LFUCache;

import java.util.HashMap;

class LFUCache {

    public DoubleLinkedNode doubleLinkedList;
    public Integer size;
    public HashMap<Integer, DoubleLinkedNode> doubleLinkedNodeMap;

    public LFUCache(int capacity) {
        this.size = capacity;
        this.doubleLinkedNodeMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (doubleLinkedNodeMap.containsKey(key)) {
            return doubleLinkedNodeMap.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
    }

    public class DoubleLinkedNode {

        public DoubleLinkedNode prev;
        public DoubleLinkedNode next;

        public Integer key;
        public Integer value;

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
