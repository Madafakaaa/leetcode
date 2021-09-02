package p340_LongestSubstringWithAtMostKDistinctCharacters;

/**
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 * <p>
 * Example 1:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 * <p>
 * Example 2:
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int end = 0, begin = 0, count = 0, maxLen = 0;
        int[] map = new int[256];

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map[c] == 0)
                count++;
            map[c]++;
            end++;

            while (count > k) {
                char c1 = s.charAt(begin);
                map[c1]--;
                if (map[c1] == 0)
                    count--;
                begin++;
            }

            maxLen = Math.max(maxLen, end - begin);
        }

        return maxLen;
    }
}
