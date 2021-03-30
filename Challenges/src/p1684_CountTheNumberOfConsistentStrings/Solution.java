package p1684_CountTheNumberOfConsistentStrings;

import java.util.HashSet;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/30 17:17
 * <p>
 * You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
 * <p>
 * Return the number of consistent strings in the array words.
 * <p>
 * Example 1:
 * <p>
 * Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * Output: 2
 * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 */
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet(allowed.length());
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        int res = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
