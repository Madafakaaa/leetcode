package p1688_CountOfMatchesInTournament;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/4/6 17:32
 * <p>
 * You are given an integer n, the number of teams in a tournament that has strange rules:
 * <p>
 * If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played, and n / 2 teams advance to the next round.
 * If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
 * Return the number of matches played in the tournament until a winner is decided.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 7
 * Output: 6
 * Explanation: Details of the tournament:
 * - 1st Round: Teams = 7, Matches = 3, and 4 teams advance.
 * - 2nd Round: Teams = 4, Matches = 2, and 2 teams advance.
 * - 3rd Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
 * Total number of matches = 3 + 2 + 1 = 6.
 */
class Solution {
    public int numberOfMatches(int n) {
        if (n < 2) return 0;
        int[] dp = new int[n];
        dp[1] = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = dp[i / 2 + i % 2] + i / 2;
        }
        return dp[n - 1];
    }
}