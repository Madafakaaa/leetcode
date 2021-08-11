package p079_WordSearch;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * <p>
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * <p>
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean backtrack(char[][] board, String word, int x, int y) {
        if (word.length() == 0) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || word.charAt(0) != board[x][y]) {
            return false;
        }
        char temp = word.charAt(0);
        word = word.substring(1);
        board[x][y] = '#';
        boolean res = backtrack(board, word, x - 1, y) || backtrack(board, word, x + 1, y) || backtrack(board, word, x, y - 1) || backtrack(board, word, x, y + 1);
        board[x][y] = temp;
        return res;
    }
}