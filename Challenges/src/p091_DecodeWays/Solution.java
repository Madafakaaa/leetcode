package p091_DecodeWays;

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' > 0) {
                if (i > 1) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = 1;
                }
            }
            if ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26 && (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') > 0) {
                if (i > 1) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i]++;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
