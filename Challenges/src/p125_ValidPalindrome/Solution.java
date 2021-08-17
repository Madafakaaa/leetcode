package p125_ValidPalindrome;

/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 */
class Solution {
    public boolean isPalindrome(String s) {
        // pre-process string
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        String processedS = sb.toString();
        for (int i = 0; i < processedS.length() / 2; i++) {
            if (processedS.charAt(i) != processedS.charAt(processedS.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
