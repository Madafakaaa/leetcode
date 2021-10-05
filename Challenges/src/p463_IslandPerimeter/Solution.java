package p463_IslandPerimeter;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/4 23:21
 */
class Solution {

    int[][] grid;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += check(i - 1, j);
                    res += check(i + 1, j);
                    res += check(i, j - 1);
                    res += check(i, j + 1);
                }
            }
        }
        return res;
    }

    public int check(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 1;
        }
        return 1 - grid[i][j];
    }
}
