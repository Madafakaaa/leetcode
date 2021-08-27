package p1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters;

import java.util.ArrayList;
import java.util.HashSet;
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

    int res;

    public int maxLength(List<String> arr) {
        res = 0;
        for (String word : arr) {
            List<String> copiedArr = new ArrayList<>(arr.size());
            copiedArr.addAll(arr);
            backtrack(word, copiedArr, new HashSet<String>());
        }
        return res;
    }

    public void backtrack(String word, List<String> arr, HashSet<String> set) {

    }
}
