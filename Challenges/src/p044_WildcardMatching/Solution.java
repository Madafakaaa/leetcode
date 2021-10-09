package p044_WildcardMatching;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/8 17:19
 */
class Solution {
    public boolean isMatch(String s, String p) {
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        boolean[][] dp = new boolean[charP.length + 1][charS.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= charP.length; i++) {
            dp[i][0] = dp[i - 1][0] && p.charAt(i - 1) == '*';
        }
        outLoop:
        for (int i = 0; i < charP.length; i++) {
            for (int j = 0; j < charS.length; j++) {
                if (dp[i][j]) {
                    if (charP[i] == '*') {
                        for (int k = j; k < charS.length + 1; k++) {
                            dp[i + 1][k] = true;
                        }
                        continue outLoop;
                    } else if (charP[i] == '?' || charP[i] == charS[j]) {
                        dp[i + 1][j + 1] = true;
                    }
                }
            }
        }
        return dp[charP.length][charS.length];
    }
}
