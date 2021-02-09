package p121_BestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, max = 0;
        for(int i=prices.length-1;i>=0;i--){
            res = Math.max(res, max-prices[i]);
            max = Math.max(max, prices[i]);
        }
        return res;
    }
}