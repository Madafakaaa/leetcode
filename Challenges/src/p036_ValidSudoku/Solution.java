package p036_ValidSudoku;

class Solution {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][][] boxes = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char temp = board[i][j];
                    if (rows[i][temp - '1'] || cols[j][temp - '1'] || boxes[i / 3][j / 3][temp - '1']) {
                        return false;
                    }
                    rows[i][temp - '1'] = true;
                    cols[j][temp - '1'] = true;
                    boxes[i / 3][j / 3][temp - '1'] = true;
                }
            }
        }
        return true;
    }

}
