package p212_WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Example 1:
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * <p>
 * Example 2:
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 */
class Solution {

    public char[][] board;
    public int height;
    public int width;
    public Set<String> res;
    public TrieNode root;
    public Set<String> wordsSet;

    public List<String> findWords(char[][] board, String[] words) {
        this.root = new TrieNode();
        this.board = board;
        this.height = board.length;
        this.width = board[0].length;
        this.wordsSet = new HashSet<>(words.length);
        for (String word : words) {
            wordsSet.add(word);
        }
        res = new HashSet<>(words.length);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                backtrack(i, j, 0, root);
            }
        }
        List<String> resList = new ArrayList<>(res);
        return resList;
    }

    public void backtrack(int i, int j, int k, TrieNode trieNode) {
        if (trieNode == null) {
            return;
        }
        // word detected
        if (trieNode.isEnd) {
            this.res.add(trieNode.word);
            return;
        }
        // backtrack
        // 1. out of bound
        if (i < 0 || j < 0 || i >= height || j >= width || board[i][j] == '#') {
            return;
        }
        // 2. current char not matching
        if (trieNode.nodes[board[i][j] - 'a'] == null) {
            return;
        }
        // 3. keep backtracking
        // replace current char
        char tempChar = board[i][j];
        board[i][j] = '#';
        backtrack(i + 1, j, k + 1, trieNode.nodes[tempChar - 'a']);
        backtrack(i - 1, j, k + 1, trieNode.nodes[tempChar - 'a']);
        backtrack(i, j + 1, k + 1, trieNode.nodes[tempChar - 'a']);
        backtrack(i, j - 1, k + 1, trieNode.nodes[tempChar - 'a']);
        // restore current char
        board[i][j] = tempChar;
    }

    public void insert(String s) {
        TrieNode node = this.root;
        for (char c : s.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new TrieNode();
            }
            node = node.nodes[c - 'a'];
        }
        node.isEnd = true;
        node.word = s;
    }

    class TrieNode {
        TrieNode[] nodes;
        boolean isEnd;
        String word;

        public TrieNode() {
            isEnd = false;
            nodes = new TrieNode[26];
        }
    }
}





























