package p200_NumberOfIslands;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
class Solution {

    int res;
    char[][] map;

    public int numIslands(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        this.res = 0;
        this.map = grid;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    this.res++;
                    clear(i, j);
                }
            }
        }
        return res;
    }

    public void clear(int i, int j) {
        if (i < 0 || j < 0 || i >= this.map.length || j >= this.map[0].length) {
            return;
        }
        if (this.map[i][j] == '1') {
            this.map[i][j] = '0';
            clear(i + 1, j);
            clear(i - 1, j);
            clear(i, j + 1);
            clear(i, j - 1);
        }
    }

}