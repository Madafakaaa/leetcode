package 剑指Offer.剑指Offer10_青蛙跳台阶问题;

import java.util.Arrays;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 14:16
 */
class Solution {

    int[] dp;

    public int numWays(int n) {
        dp = new int[n + 2];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        return helper(n);
    }

    public int helper(int n) {
        if (dp[n] == -1) {
            dp[n] = (helper(n - 1) + helper(n - 2)) % 1000000007;
        }
        return dp[n];
    }

}
