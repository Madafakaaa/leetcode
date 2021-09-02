package p706_DesignHashMap;

import java.util.ArrayList;

/**
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * Implement the MyHashMap class:
 * <p>
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
 * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * Output
 * [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * Explanation
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // The map is now [[1,1]]
 * myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
 * myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
 * myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
 * myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
 * myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
 * myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
 * myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 */
class MyHashMap {

    ArrayList<ArrayList<Node>> map;
    int hashBase;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        hashBase = 10;
        map = new ArrayList(hashBase);
        for (int i = 0; i < hashBase; i++) {
            map.add(new ArrayList<>());
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        ArrayList<Node> hashBucket = map.get(key % hashBase);
        for (Node node : hashBucket) {
            if (node.key == key) {
                node.val = value;
                return;
            }
        }
        hashBucket.add(new Node(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        ArrayList<Node> hashBucket = map.get(key % hashBase);
        for (Node node : hashBucket) {
            if (node.key == key) {
                return node.val;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        ArrayList<Node> hashBucket = map.get(key % hashBase);
        for (int i = 0; i < hashBucket.size(); i++) {
            Node node = hashBucket.get(i);
            if (node.key == key) {
                hashBucket.remove(i);
                return;
            }
        }
    }

    class Node {
        public int key;
        public int val;

        public Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
