import java.util.ArrayList;

public class MyHashMap {
    public static int bucketNum = 10000;
    public ArrayList<int[]> buckets;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        buckets = new ArrayList<int[]>();
        for (int i = 0; i < bucketNum; i++) {
            int[] bucket = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            buckets.add(bucket);
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        buckets.get(key % bucketNum)[key / bucketNum] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return buckets.get(key % bucketNum)[key / bucketNum];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        buckets.get(key % bucketNum)[key / bucketNum] = -1;
    }
}
