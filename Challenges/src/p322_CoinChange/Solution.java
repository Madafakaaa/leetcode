package p322_CoinChange;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 * <p>
 * Example 4:
 * Input: coins = [1], amount = 1
 * Output: 1
 * <p>
 * Example 5:
 * Input: coins = [1], amount = 2
 * Output: 2
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= amount; i++) {
            if (dp[i] == 1) {
                continue;
            }
            int localMin = Integer.MAX_VALUE;
            for (int coin : coins) {
                int prev = i - coin;
                if ((i - coin > 0) && dp[i - coin] != -1) {
                    localMin = Math.min(localMin, dp[i - coin] + 1);
                }
            }
            dp[i] = localMin == Integer.MAX_VALUE ? -1 : localMin;
        }
        return dp[amount];
    }
}