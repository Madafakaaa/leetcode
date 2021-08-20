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
    public Set<String> wordsSet;

    public List<String> findWords(char[][] board, String[] words) {
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
                Set<String> localSet = new HashSet<>(wordsSet);
                for (String word : localSet) {
                    backtrack(i, j, 0, word);
                }
            }
        }
        List<String> resList = new ArrayList<>(res);
        return resList;
    }

    public void backtrack(int i, int j, int k, String word) {
        if (res.contains(word)) {
            return;
        }
        // word detected
        if (k >= word.length()) {
            this.res.add(word);
            wordsSet.remove(word);
            return;
        }
        // backtrack
        // 1. out of bound
        if (i < 0 || j < 0 || i >= height || j >= width) {
            return;
        }
        // 2. current char not matching
        if (board[i][j] != word.charAt(k)) {
            return;
        }
        // 3. keep backtracking
        // replace current char
        board[i][j] = '#';
        backtrack(i + 1, j, k + 1, word);
        backtrack(i - 1, j, k + 1, word);
        backtrack(i, j + 1, k + 1, word);
        backtrack(i, j - 1, k + 1, word);
        // restore current char
        board[i][j] = word.charAt(k);
    }

}

