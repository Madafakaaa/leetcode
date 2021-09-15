package 剑指Offer.剑指Offer46_把数字翻译成字符串;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 23:00
 */
class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int twoDigit = (str.charAt(i - 1) - '0') * 10 + (str.charAt(i) - '0');
            if (twoDigit >= 10 && twoDigit <= 25) {
                if (i > 1) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i]++;
                }
            }
            dp[i] += dp[i - 1];
        }
        return dp[str.length() - 1];
    }
}
