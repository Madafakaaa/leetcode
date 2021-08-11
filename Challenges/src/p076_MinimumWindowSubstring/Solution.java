package p076_MinimumWindowSubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * <p>
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * <p>
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        int[] count = new int[t.length()];
        int cNum = 0;
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                map.putIfAbsent(c, cNum);
                count[cNum] = 1;
                cNum++;
            } else {
                count[map.get(c)]++;
            }
        }
        int left = 0, right = 0, minLength = s.length();
        String res = null;
        while (right < s.length() - 2) {
            if (Arrays.stream(count).sum() == 0) { // contains all characters
                if (map.containsKey(t.charAt(left))) count[map.get(t.charAt(left))]++;
                left++;
                if (right - left < minLength) {
                    minLength = right - left;
                    res = s.substring(left, right);
                }
            } else { // does not contain all characters
                right++;
                if (map.containsKey(t.charAt(right))) count[map.get(t.charAt(right))]--;
            }
        }
        return res;
    }
}