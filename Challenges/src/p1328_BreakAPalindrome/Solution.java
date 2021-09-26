package p1328_BreakAPalindrome;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/23 21:04
 */
class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                palindrome = palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
                return palindrome;
            }
        }
        return palindrome.substring(0, palindrome.length() - 1) + "b";
    }

}
