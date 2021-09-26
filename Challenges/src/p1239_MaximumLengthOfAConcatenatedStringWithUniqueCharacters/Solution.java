package p1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters;

import java.util.List;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * Example 1:
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 */
class Solution {
    public int maxLength(List<String> arr) {
        return maxLength(arr, 0, new boolean[26]);
    }

    private int maxLength(List<String> arr, int index, boolean[] exists) {
        if (index == arr.size()) {
            return 0;
        }
        String curr = arr.get(index);
        // without curr string
        int without = maxLength(arr, index + 1, exists);
        int end = 0;
        while (end < curr.length() && !exists[curr.charAt(end) - 'a']) {
            exists[curr.charAt(end) - 'a'] = true;
            end++;
        }
        int with = 0;
        if (end == curr.length()) {
            with = maxLength(arr, index + 1, exists) + curr.length();
        }
        unmark(exists, end - 1, curr);
        return Math.max(with, without);
    }

    private void unmark(boolean[] exists, int end, String curr) {
        for (int i = 0; i <= end; i++) {
            exists[curr.charAt(i) - 'a'] = false;
        }
    }
}
