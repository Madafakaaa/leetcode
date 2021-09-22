package p677_MapSumPairs;

import java.util.HashMap;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/20 23:57
 */
class MapSum {

    Node root;
    HashMap<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node(' ');
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        Node temp = this.root;
        int extra = val - map.getOrDefault(key, 0);
        for (char c : key.toCharArray()) {
            if (temp.nodes[c - 'a'] == null) {
                temp.nodes[c - 'a'] = new Node(c);
            }
            temp.nodes[c - 'a'].count += extra;
            temp = temp.nodes[c - 'a'];
        }
        map.put(key, val);
    }

    public int sum(String prefix) {
        Node temp = this.root;
        for (char c : prefix.toCharArray()) {
            if (temp.nodes[c - 'a'] == null) {
                return 0;
            }
            temp = temp.nodes[c - 'a'];
        }
        return temp.count;
    }


    public class Node {

        char c;
        int count;
        Node[] nodes;


        public Node(char c) {
            this.count = 0;
            this.c = c;
            this.nodes = new Node[26];
        }

    }
}


/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
