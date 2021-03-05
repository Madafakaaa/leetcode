package p064_MinimumPathSum;

class Solution {

    public int minPathSum(int[][] grid) {
        int[][] pathSum = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j > 0 && i > 0) {
                    pathSum[i][j] = Math.min(pathSum[i - 1][j] + grid[i - 1][j], pathSum[i][j - 1] + grid[i][j - 1]);
                } else if (j > 0) {
                    pathSum[i][j] = pathSum[i][j - 1] + grid[i][j - 1];
                } else if (i > 0) {
                    pathSum[i][j] = pathSum[i - 1][j] + grid[i - 1][j];
                }
            }
        }
        return pathSum[grid.length - 1][grid[0].length - 1] + grid[grid.length - 1][grid[0].length - 1];
    }

}