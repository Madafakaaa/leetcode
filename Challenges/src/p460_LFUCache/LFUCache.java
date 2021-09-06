package p460_LFUCache;

import java.util.HashMap;

class LFUCache {

    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DoubleLinkedList> frequencyMap;
    int minFrequency;
    int capacity;

    public LFUCache(int capacity) {
        keyMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        minFrequency = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        DoubleLinkedList doubleLinkedList = frequencyMap.get(node.frequency);
        doubleLinkedList.removeFromList(node);
        if (doubleLinkedList.isEmpty()) {
            frequencyMap.remove(node.frequency);
            if (node.frequency == minFrequency) {
                minFrequency++;
            }
        }
        node.frequency++;
        DoubleLinkedList newDoubleLinkedList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
        newDoubleLinkedList.addToTail(node);
        frequencyMap.put(node.frequency, newDoubleLinkedList);
        return node.value;
    }

    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            DoubleLinkedList doubleLinkedList = frequencyMap.get(node.frequency);
            doubleLinkedList.removeFromList(node);
            if (doubleLinkedList.isEmpty()) {
                frequencyMap.remove(node.frequency);
                if (node.frequency == minFrequency) {
                    minFrequency++;
                }
            }
            node.frequency++;
            DoubleLinkedList newDoubleLinkedList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
            newDoubleLinkedList.addToTail(node);
            frequencyMap.put(node.frequency, newDoubleLinkedList);
        } else {
            if (capacity == 0) {
                return;
            }
            if (keyMap.size() >= capacity) {
                DoubleLinkedList minFrequencyDoubleLinkedList = frequencyMap.get(minFrequency);
                Node removed = minFrequencyDoubleLinkedList.popFirst();
                if (minFrequencyDoubleLinkedList.isEmpty()) {
                    frequencyMap.remove(minFrequency);
                }
                keyMap.remove(removed.key);
            }
            DoubleLinkedList oneFrequencyDoubleLinkedList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            Node newNode = new Node(key, value, 1);
            oneFrequencyDoubleLinkedList.addToTail(newNode);
            minFrequency = 1;
            keyMap.put(key, newNode);
            frequencyMap.put(1, oneFrequencyDoubleLinkedList);
        }
    }

    public class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }

    public class DoubleLinkedList {

        Node head;
        Node tail;

        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
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

        public Node popFirst() {
            if (isEmpty()) {
                return null;
            }
            Node first = head.next;
            removeFromList(first);
            return first;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }
}





















