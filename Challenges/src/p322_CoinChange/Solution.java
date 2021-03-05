package p322_CoinChange;

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int res = 0;
        int currCoin = coins.length - 1;
        while (currCoin >= 0 && amount > 0) {
            if (coins[currCoin] > amount) {
                currCoin--;
            } else {
                amount -= coins[currCoin];
                res++;
            }
        }
        if (amount > 0) return -1;
        return res;
    }

}