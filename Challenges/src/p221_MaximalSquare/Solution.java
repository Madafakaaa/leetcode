package p221_MaximalSquare;

class Solution {

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int p1 = 0, p2 = 0, p3 = 0;
                    if (i > 0 && j > 0) p1 = dp[i - 1][j - 1];
                    if (i > 0) p2 = dp[i - 1][j];
                    if (j > 0) p3 = dp[i][j - 1];
                    dp[i][j] = Math.min(p1, Math.min(p2, p3)) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }

}