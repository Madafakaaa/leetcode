package p648_ReplaceWords;


import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/21 0:09
 */
class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for (String word : dictionary) {
            insert(word, root);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(" " + search(s, root));
        }
        String res = sb.toString();
        return res.substring(1);
    }


    public void insert(String key, Node root) {
        Node node = root;
        for (char c : key.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new Node();
            }
            if (node.isEnd) {
                return;
            }
            node = node.nodes[c - 'a'];
        }
        node.isEnd = true;
    }


    public String search(String key, Node root) {
        Node node = root;
        int count = 0;
        for (char c : key.toCharArray()) {
            if (node.isEnd) {
                return key.substring(0, count);
            }
            if (node.nodes[c - 'a'] == null) {
                return key;
            }
            count++;
            node = node.nodes[c - 'a'];
        }
        return key;
    }


    public class Node {

        boolean isEnd;
        Node[] nodes;

        public Node() {
            this.isEnd = false;
            this.nodes = new Node[26];
        }

    }
}























