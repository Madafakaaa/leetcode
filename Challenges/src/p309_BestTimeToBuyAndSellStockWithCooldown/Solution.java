package p309_BestTimeToBuyAndSellStockWithCooldown;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] dp = new int[prices.length];
        if (prices[1] > prices[0]) dp[1] = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            int localMax = 0;
            for (int j = 0; j < i; j++) {
                for (int k = j + 2; k < i; k++) {
                    localMax = Math.max(localMax, dp[j] + prices[i] - prices[k]);
                }
            }
        }
        return prices[prices.length - 1];
    }
}
