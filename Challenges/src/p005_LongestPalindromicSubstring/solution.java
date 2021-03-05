package p005_LongestPalindromicSubstring;

class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String substring = helper(i, s);
            if (substring.length() > result.length()) {
                result = substring;
            }
        }
        return result;
    }

    public String helper(int startIndex, String s) {
        int upper = startIndex, lower = startIndex;
        String result = s.substring(startIndex, startIndex + 1);
        while (lower > 0 && upper < s.length() - 1) {
            if (s.charAt(lower - 1) == s.charAt(upper + 1)) {
                lower--;
                upper++;
            } else {
                break;
            }
        }
        String result1 = s.substring(lower, upper + 1);
        upper = startIndex;
        lower = startIndex;
        if (upper < s.length() - 1 && s.charAt(startIndex) == s.charAt(startIndex + 1)) {
            upper++;
        }
        while (lower > 0 && upper < s.length() - 1) {
            if (s.charAt(lower - 1) == s.charAt(upper + 1)) {
                lower--;
                upper++;
            } else {
                break;
            }
        }
        String result2 = s.substring(lower, upper + 1);
        return result1.length() > result2.length() ? result1 : result2;
    }
}
