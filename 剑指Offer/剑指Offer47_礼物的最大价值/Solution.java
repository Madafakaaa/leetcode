package 剑指Offer.剑指Offer47_礼物的最大价值;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 22:53
 */
class Solution {

    public int maxValue(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        if (height == 0 || width == 0) {
            return 0;
        }
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < height; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < width; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[height - 1][width - 1];
    }
}
