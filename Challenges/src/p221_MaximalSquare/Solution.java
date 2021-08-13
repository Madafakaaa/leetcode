package p221_MaximalSquare;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * <p>
 * Example 2:
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * <p>
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 */
class Solution {

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int p1 = 0, p2 = 0, p3 = 0;
                    if (i > 0 && j > 0) {
                        p1 = dp[i - 1][j - 1];
                    }
                    if (i > 0) {
                        p2 = dp[i - 1][j];
                    }
                    if (j > 0) {
                        p3 = dp[i][j - 1];
                    }
                    dp[i][j] = Math.min(p1, Math.min(p2, p3)) + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res * res;
    }

}