package p1578_MinimumDeletionCostToAvoidRepeatingLetters;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/2 23:17
 */
class Solution {
    public int minCost(String s, int[] cost) {
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            int min_value = 0;
            char c1 = s.charAt(i);
            char c2 = s.charAt(i - 1);
            if (c1 == c2) {
                if (cost[i] <= cost[i - 1]) {
                    min_value = cost[i];
                    cost[i] = cost[i - 1];
                } else
                    min_value = cost[i - 1];
                result += min_value;
            }
        }
        return result;
    }
}
