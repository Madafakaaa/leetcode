package 剑指Offer.剑指Offer63_股票的最大利润;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 15:26
 */
class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
