package p000_Interview;

import java.util.HashMap;

/**
 * 1.输入字符串，返回其中的最长回文字符串。回文字符串的定义是从左到右连续读和从右到左连续读的结果一样。
 * 2.请用你能想到的最优（时间空间）算法实现，哪种IDE和语言都可以。请共享桌面。
 * 3.要考虑到你的function是部署在internet上给全球数以亿计的用户使用的
 * 4.要列出你能想到的最全的功能测试用例集合，调用你的方法，自动循环输出每一个测试的结果
 */
public class Solution {

    HashMap<String, String> cache = new HashMap<>();

    public static void main(String[] args) {
        // Test cases
        String[] testCases = new String[]{
                null, "", " ", "  ",
                "a", "aa", "ab", "abb", "aba", "abcba", "abccba", "abcccba", "abbbbbbbbba",
                "A", "AA", "ABA", "ABBA", "ABBBA",
                "1", "10", "101", "1001",
                "一", "一二", "一二二", "一二二二", "一二一",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+"};
        // Execution
        Solution solution = new Solution();
        for (String testCase : testCases) {
            System.out.println("Test case: [" + testCase + "], output: [" + solution.longestPalindrome(testCase) + "]");
        }
    }

    public String longestPalindrome(String str) {
        // if the input is null or empty return an empty string
        if (str == null || str.isEmpty()) {
            return "";
        }
        // check the cache for result
        if (cache.containsKey(str)) {
            return cache.get(str);
        }
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            // if the remain string cannot find an answer that is longer than the current longest palindrome found
            // then return the answer right away
            if (res.length() >= (str.length() - 1 - i) * 2 + 1) {
                return res;
            }
            // find the longest palindrome expanded from the current index
            String palindrome1 = helper(str, i, i);
            if (palindrome1.length() > res.length()) {
                res = palindrome1;
            }
            if (i < str.length() - 1) {
                String palindrome2 = helper(str, i, i + 1);
                if (palindrome2.length() > res.length()) {
                    res = palindrome2;
                }
            }
        }
        // add the input and the result to the cache
        cache.put(str, res);
        return res;
    }

    public String helper(String str, int i, int j) {
        // if the current string cannot form a palindrome return an empty string
        if (i < 0 || j >= str.length() || str.charAt(i) != str.charAt(j)) {
            return "";
        }
        // the current string can form a palindrome, keep expanding the string
        String next = helper(str, i - 1, j + 1);
        if (next.isEmpty()) {
            // if the string can expand return the expanded string
            return str.substring(i, j + 1);
        } else {
            // if the string cannot expand return the current string
            return next;
        }
    }

}

