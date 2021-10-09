package p208_ImplementTriePrefixTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/14 0:22
 */
class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new Node();
            }
            node = node.nodes[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                return false;
            }
            node = node.nodes[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                return false;
            }
            node = node.nodes[c - 'a'];
        }
        return true;
    }

}

class Node {
    boolean isEnd;
    Node[] nodes;

    public Node() {
        this.isEnd = false;
        nodes = new Node[26];
    }
}
