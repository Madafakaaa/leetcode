package p763_PartitionLabels;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 * <p>
 * Return a list of integers representing the size of these parts.
 * <p>
 * Example 1:
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 * Input: s = "eccbbbbdec"
 * Output: [10]
 */
class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) lastIndex[S.charAt(i) - 'a'] = i;
        int last = 0, prevLast = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastIndex[S.charAt(i) - 'a']);
            if (last == i) {
                res.add(i - prevLast + 1);
                prevLast = i + 1;
            }
        }
        return res;
    }

}