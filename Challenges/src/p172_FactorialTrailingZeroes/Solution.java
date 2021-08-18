package p172_FactorialTrailingZeroes;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * <p>
 * Example 2:
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * <p>
 * Example 3:
 * Input: n = 0
 * Output: 0
 */
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i += 5) { //!
            int temp = i;
            while (temp % 5 == 0) {
                res++;
                temp = temp / 5;
            }
        }
        return res;
    }
}