package p037_SudokuSolver;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/9 11:13
 */
class Solution {

    boolean[][] rows;
    boolean[][] cols;
    boolean[][][] boxes;
    int count;

    public void solveSudoku(char[][] board) {
        rows = new boolean[9][9];
        cols = new boolean[9][9];
        boxes = new boolean[3][3][9];
        count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char temp = board[i][j];
                    rows[i][temp - '1'] = true;
                    cols[j][temp - '1'] = true;
                    boxes[i / 3][j / 3][temp - '1'] = true;
                    count++;
                }
            }
        }
        backtrack(0, 0, board);
    }

    public boolean backtrack(int i, int j, char[][] board) {
        if (count == 81) {
            return true;
        }
        if (board[i][j] == '.') {
            for (int k = 0; k < 9; k++) {
                if (rows[i][k] == false && cols[j][k] == false && boxes[i / 3][j / 3][k] == false) {
                    board[i][j] = (char) ('1' + k);
                    count++;
                    rows[i][k] = true;
                    cols[j][k] = true;
                    boxes[i / 3][j / 3][k] = true;
                    if (backtrack(i + (j + 1) / 9, (j + 1) % 9, board)) {
                        return true;
                    }
                    // recover
                    board[i][j] = '.';
                    count--;
                    rows[i][k] = false;
                    cols[j][k] = false;
                    boxes[i / 3][j / 3][k] = false;
                }
            }
            return false;
        } else {
            return backtrack(i + (j + 1) / 9, (j + 1) % 9, board);
        }
    }

}
