package p140_WordBreakII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Example 1:
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * <p>
 * Example 2:
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * <p>
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        List<String>[] res = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            res[i] = new ArrayList<String>();
        }
        for (String word : wordDict) {
            if (s.length() >= word.length() && s.substring(0, word.length()).equals(word)) {
                res[word.length() - 1].add(word);
            }
        }
        for (int i = 0; i < length - 1; i++) {
            if (res[i].size() > 0) {
                for (String word : wordDict) {
                    if (s.length() > i + word.length() && s.substring(i + 1, i + word.length() + 1).equals(word)) {
                        for (String prev : res[i]) {
                            res[i + word.length()].add(prev + " " + word);
                        }
                    }
                }
            }
        }
        return res[length - 1];

    }
}
