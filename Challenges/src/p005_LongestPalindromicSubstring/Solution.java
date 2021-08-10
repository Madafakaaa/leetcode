package p005_LongestPalindromicSubstring;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 * <p>
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 * <p>
 * Input: s = "ac"
 * Output: "a"
 */
class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String temp1 = getPalindrome(s, i, i);
            if (temp1.length() > res.length()) {
                res = temp1;
            }
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                String temp2 = getPalindrome(s, i, i + 1);
                if (temp2.length() > res.length()) {
                    res = temp2;
                }
            }
        }
        return res;
    }

    public String getPalindrome(String s, int left, int right) {
        while (left - 1 >= 0 && right + 1 < s.length()) {
            if (s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left, right + 1);
    }

}
