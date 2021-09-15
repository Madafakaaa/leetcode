package p208_ImplementTriePrefixTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/14 0:22
 */
class Trie {

    Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.suffix[c - 'a'] == null) {
                node.suffix[c - 'a'] = new Node(c);
            }
            node = node.suffix[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.suffix[c - 'a'] == null) {
                return false;
            }
            node = node.suffix[c - 'a'];
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.suffix[c - 'a'] == null) {
                return false;
            }
            node = node.suffix[c - 'a'];
        }
        return true;
    }

    public class Node {
        char c;
        boolean isEnd;
        Node[] suffix;

        public Node() {
            this.suffix = new Node[26];
        }

        public Node(char c) {
            this.c = c;
            this.suffix = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
