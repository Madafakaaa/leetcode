package 剑指Offer.剑指Offer12_矩阵中的路径;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 14:47
 */
class Solution {

    char[][] board;
    char[] chars;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != chars[k]) {
            return false;
        }
        if (k == chars.length - 1) {
            return true;
        }
        board[i][j] = '#';
        boolean res = backtrack(i + 1, j, k + 1) ||
                backtrack(i - 1, j, k + 1) ||
                backtrack(i, j + 1, k + 1) ||
                backtrack(i, j - 1, k + 1);
        board[i][j] = chars[k];
        return res;
    }
}
