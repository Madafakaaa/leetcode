package p007_ReverseInteger;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 * Input: x = 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: x = -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: x = 120
 * Output: 21
 * <p>
 * Example 4:
 * Input: x = 0
 * Output: 0
 */
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res;
            res = 10 * res + x % 10;
            if (res / 10 != temp) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }
}
