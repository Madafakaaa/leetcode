package 剑指Offer.剑指Offer48_最长不含重复字符的子字符串;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 22:46
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        boolean[] exist = new boolean[255];
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            while (exist[s.charAt(right)]) {
                exist[s.charAt(left)] = false;
                left++;
            }
            exist[s.charAt(right)] = true;
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }
}
