package p1578_MinimumDeletionCostToAvoidRepeatingLetters;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/2 23:17
 */
class Solution {
    public int minCost(String s, int[] cost) {
        if (s.length() <= 1) {
            return 0;
        }
        int totalCost = 0;
        int tempTotalCost = 0;
        int tempMaxCost = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                while (i < s.length() && chars[i] == chars[i + 1]) {
                    tempTotalCost += cost[i];
                    tempMaxCost = Math.max(tempMaxCost, cost[i]);
                    i++;
                }
                tempTotalCost += cost[i];
                tempMaxCost = Math.min(tempMaxCost, cost[i]);
                totalCost += tempTotalCost - tempMaxCost;
                tempTotalCost = 0;
                tempMaxCost = Integer.MAX_VALUE;
            }
        }
        return totalCost;
    }
}
