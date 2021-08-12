package p139_WordBreak;

import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * <p>
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (String word : wordDict) {
            if (s.length() >= word.length() && s.substring(0, word.length()).equals(word)) {
                dp[word.length() - 1] = true;
            }
        }
        for (int i = 0; i < dp.length - 1; i++) {
            if (dp[i]) {
                for (String word : wordDict) {
                    if (s.length() >= i + word.length() + 1 && s.substring(i + 1, i + 1 + word.length()).equals(word)) {
                        dp[i + word.length()] = true;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }

}