package 剑指Offer.剑指Offer60_n个骰子的点数;

import java.util.Arrays;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 17:27
 */
class Solution {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
