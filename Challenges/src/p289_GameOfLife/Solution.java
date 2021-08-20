package p289_GameOfLife;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 * <p>
 * Example 1:
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * <p>
 * Example 2:
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 */
class Solution {

    int[][] prevPublicBoard;
    int[][] board;
    int height;
    int width;

    public void gameOfLife(int[][] board) {
        height = board.length;
        width = board[0].length;
        this.board = board;
        prevPublicBoard = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; i < height; i++) {
                prevPublicBoard[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; i < height; i++) {
                board[i][j] = update(i, j);
            }
        }
    }

    public int update(int i, int j) {
        int countNeighbour = 0;
        countNeighbour += check(i - 1, j - 1);
        countNeighbour += check(i - 1, j);
        countNeighbour += check(i - 1, j + 1);
        countNeighbour += check(i, j - 1);
        countNeighbour += check(i, j + 1);
        countNeighbour += check(i + 1, j - 1);
        countNeighbour += check(i + 1, j);
        countNeighbour += check(i + 1, j + 1);
        if (prevPublicBoard[i][j] == 1) {
            if (countNeighbour < 2 || countNeighbour > 3) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (countNeighbour == 3) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int check(int i, int j) {
        if (i < 0 || j < 0 || i >= height || j > width) {
            return 0;
        }
        return prevPublicBoard[i][j];
    }

}
