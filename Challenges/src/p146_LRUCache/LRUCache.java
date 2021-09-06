package p146_LRUCache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>(capacity);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeFromList(node);
            addToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeFromList(node);
            node.value = value;
            addToTail(node);
            map.put(key, node);
        } else {
            if (map.size() >= capacity) {
                Node removed = removeFromList(head.next);
                map.remove(removed.key);
            }
            Node node = new Node(key, value);
            addToTail(node);
            map.put(key, node);
        }
    }

    public void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public Node removeFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        return node;
    }

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {

        }

        public Node(int key, int value) {
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
 */
