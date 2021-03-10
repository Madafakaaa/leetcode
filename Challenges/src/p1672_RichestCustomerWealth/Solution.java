package p1672_RichestCustomerWealth;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/10 9:46
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        if (accounts.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int tempMax;
        for (int[] account : accounts) {
            tempMax = 0;
            for (int a : account) {
                tempMax += a;
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }
}