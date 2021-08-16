package p647_PalindromicSubstrings;

/**
 * Given a string s, return the number of palindromic substrings in it.
 * <p>
 * A string is a palindrome when it reads the same backward as forward.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Example 1:
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <p>
 * Example 2:
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
class Solution {

    public int res = 0;
    public char[] chars;

    public int countSubstrings(String s) {
        chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            count(i, i);
            count(i, i + 1);
        }
        return res + 1;
    }

    public void count(int left, int right) {
        if (left < 0 || right >= chars.length) return;
        if (chars[left] == chars[right]) {
            res++;
            count(left - 1, right + 1);
        }
    }
}