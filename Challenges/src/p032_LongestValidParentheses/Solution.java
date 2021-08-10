package p032_LongestValidParentheses;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 */
class Solution {
    public int longestValidParentheses(String s) {
        int[] len = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    len[i] = 2;
                    if (i - 2 > 0) {
                        len[i] += len[i - 2];
                    }
                } else if (i - 1 - len[i - 1] >= 0 && s.charAt(i - 1 - len[i - 1]) == '(') {
                    len[i] = len[i - 1] + 2;
                    if (i - 2 - len[i - 1] > 0) {
                        len[i] += len[i - 2 - len[i - 1]];
                    }
                }
            }
            res = Math.max(res, len[i]);
        }
        return res;
    }
}