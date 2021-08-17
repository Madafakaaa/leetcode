package p003_LongestSubstringWithoutRepeatingCharacter;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Example 4:
 * Input: s = ""
 * Output: 0
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] count = new int[256];
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            while (count[s.charAt(i)] != 0) {
                count[s.charAt(left)]--;
                left++;
            }
            count[s.charAt(i)]++;
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

}