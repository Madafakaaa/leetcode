import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    public ArrayList<List<Integer>> buckets;
    public static int bucketNum = 10000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new ArrayList<List<Integer>>();
        for(int i = 0;i<bucketNum;i++){
            ArrayList<Integer> bucket = new ArrayList<>();
            buckets.add(bucket);
        }

    }

    public void add(int key) {
        if(!buckets.get(key%bucketNum).contains(key)){
            buckets.get(key%bucketNum).add(key);
        }
    }

    public void remove(int key) {
        if(buckets.get(key%bucketNum).contains(key)){
            buckets.get(key%bucketNum).remove((Object)key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(buckets.get(key%bucketNum).contains(key)){
            return true;
        }
        return false;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */