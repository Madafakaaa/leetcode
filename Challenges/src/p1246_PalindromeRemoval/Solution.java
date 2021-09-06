package p1246_PalindromeRemoval;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/6 11:03
 */
class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; ++j) {
            for (int i = j; i >= 0; --i) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i == j - 1) {
                    dp[i][j] = arr[i] == arr[j] ? 1 : 2;
                } else if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // !!
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; ++k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
