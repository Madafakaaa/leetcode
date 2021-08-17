package p131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * <p>
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        backtracking(s, 0, new LinkedList<String>(), result);
        return result;
    }


    private void backtracking(String s, int startIndex, LinkedList<String> list, List<List<String>> result) {
        if (s.length() == startIndex) {
            //add palindrome list
            result.add(new ArrayList(list));
            return;
        }
        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            //check for palindrome
            if (!isPalindrome(s, startIndex, endIndex)) continue;
            //add this palidrome
            list.add(s.substring(startIndex, endIndex + 1));
            backtracking(s, endIndex + 1, list, result);
            //remove last palindrome
            list.removeLast();
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        r = Math.min(r, s.length() - 1);
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}