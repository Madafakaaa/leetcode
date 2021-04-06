package p1221_SplitStringInBalancedStrings;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/4/6 17:20
 * <p>
 * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 * <p>
 * Given a balanced string s, split it in the maximum amount of balanced strings.
 * <p>
 * Return the maximum amount of split balanced strings.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 * <p>
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 */
class Solution {
    public int balancedStringSplit(String s) {
        int res = 0;
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                res++;
            }
        }
        return res;
    }
}