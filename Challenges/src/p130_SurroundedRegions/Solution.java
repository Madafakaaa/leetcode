package p130_SurroundedRegions;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example 1:
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 * Input: board = [["X"]]
 * Output: [["X"]]
 */
class Solution {

    char[][] board;
    int height;
    int width;

    public void solve(char[][] board) {
        this.board = board;
        height = board.length;
        width = board[0].length;
        flipFromEdge();
        flipSurrounded();
    }

    public void flipFromEdge() {
        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O') {
                flip(i, 0);
            }
            if (board[i][width - 1] == 'O') {
                flip(i, width - 1);
            }
        }
        for (int i = 1; i < width; i++) {
            if (board[0][i] == 'O') {
                flip(0, i);
            }
            if (board[height - 1][i] == 'O') {
                flip(height - 1, i);
            }
        }
    }

    public void flip(int i, int j) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'C';
            flip(i + 1, j);
            flip(i - 1, j);
            flip(i, j + 1);
            flip(i, j - 1);
        }
    }

    public void flipSurrounded() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'C') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
